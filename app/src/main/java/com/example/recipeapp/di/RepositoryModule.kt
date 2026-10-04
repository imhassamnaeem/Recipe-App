package com.example.recipeapp.di

import com.example.recipeapp.data.repo.RecipeRepositoryImpl
import com.example.recipeapp.domain.repo.RecipeRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

@Singleton
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRecipeRepository(
        repositoryImpl: RecipeRepositoryImpl
    ): RecipeRepo
}
