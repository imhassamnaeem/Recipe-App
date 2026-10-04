package com.example.recipeapp.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.core.shared.datastore.OnboardingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class SplashViewModel @Inject constructor(
    val onboardingPreference: OnboardingPreferences
) : ViewModel() {
    private val _splashEvent = MutableSharedFlow<SplashEvent>()
    val splashEvent = _splashEvent.asSharedFlow()

    fun checkSplash() {
        viewModelScope.launch {
            delay(2000.milliseconds)
            val completed = onboardingPreference.isOnboardingCompleted.first()
            if (completed) {
                _splashEvent.emit(SplashEvent.OnNavigateToOnboarding)
            } else {
                _splashEvent.emit(SplashEvent.OnNavigateToHome)
            }
        }
    }
}

sealed class SplashEvent {
    data object OnNavigateToOnboarding : SplashEvent()
    data object OnNavigateToHome : SplashEvent()
}