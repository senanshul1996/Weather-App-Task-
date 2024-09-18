package com.example.weathertaskapp.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore("user_prefs")

class DataStoreManager(private val context: Context) {

    companion object {
        val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
    }


    suspend fun saveLoginState(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN_KEY] = isLoggedIn
        }
    }


    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[IS_LOGGED_IN_KEY] ?: false
        }
}
