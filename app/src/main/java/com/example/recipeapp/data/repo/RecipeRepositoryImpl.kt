package com.example.recipeapp.data.repo

import com.example.recipeapp.data.remote.api.MealApiService
import com.example.recipeapp.data.remote.dto.toMeal
import com.example.recipeapp.domain.model.Meal
import com.example.recipeapp.domain.repo.RecipeRepo
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val apiService: MealApiService
) : RecipeRepo {
    override suspend fun getRecipeList(query: String): List<Meal> {
        return apiService.getMealList(query).meals
            ?.map {
                it.toMeal()
            }
            .orEmpty()
    }
}