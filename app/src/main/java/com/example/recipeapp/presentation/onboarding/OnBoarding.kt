package com.example.recipeapp.presentation.onboarding

import androidx.fragment.app.viewModels
import com.example.recipeapp.core.shared.base.BaseFragment
import com.example.recipeapp.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoarding : BaseFragment<FragmentOnBoardingBinding, OnBoardingViewModel>(
    FragmentOnBoardingBinding::inflate
) {
    override val viewModel: OnBoardingViewModel by viewModels()

    private val adapter = OnboardingAdapter(
        OnboardingData.pages
    )

    override fun setUpViews() {
        binding.apply {
            viewpagerOnboarding.adapter = adapter

        }
    }

    override fun observeData() {

    }
}