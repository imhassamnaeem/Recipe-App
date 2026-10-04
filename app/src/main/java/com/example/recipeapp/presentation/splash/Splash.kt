package com.example.recipeapp.presentation.splash

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipeapp.R
import com.example.recipeapp.core.shared.base.BaseFragment
import com.example.recipeapp.core.shared.extensions.loadAndCollectOnStarted
import com.example.recipeapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    FragmentSplashBinding::inflate
) {
    override val viewModel: SplashViewModel by viewModels()

    override fun setUpViews() {
        viewModel.checkSplash()
    }

    override fun observeData() {
        loadAndCollectOnStarted {
            viewModel.splashEvent.collect { event ->
                when (event) {
                    SplashEvent.OnNavigateToOnboarding -> {
                        findNavController().navigate(
                            R.id.action_splash_to_onBoarding
                        )
                    }

                    SplashEvent.OnNavigateToHome -> {
                        findNavController().navigate(
                            R.id.action_splash_to_home
                        )
                    }
                }
            }
        }
    }
}