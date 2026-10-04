package com.example.recipeapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import com.example.recipeapp.core.shared.datastore.OnboardingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onboardingPreference: OnboardingPreferences
) : ViewModel() {
    private val _onboardingEvent = MutableSharedFlow<OnBoardingEvents>()
    val onboardingEvent = _onboardingEvent.asSharedFlow()


}

sealed class OnBoardingEvents{
    data object OnNavigateToHome : OnBoardingEvents()
}