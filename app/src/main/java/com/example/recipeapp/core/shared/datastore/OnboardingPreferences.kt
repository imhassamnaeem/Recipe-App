package com.example.recipeapp.core.shared.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnboardingPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val onBoardingCompletedKey = booleanPreferencesKey("onboarding_completed")
    val isOnboardingCompleted: Flow<Boolean> =
        dataStore.data.map { preferences ->
            preferences[onBoardingCompletedKey] ?: false
        }

    suspend fun setOnboardingCompleted() {
        dataStore.edit { preferences ->
            preferences[onBoardingCompletedKey] = true
        }
    }
}