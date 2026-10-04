package com.example.recipeapp.domain.repo

import com.example.recipeapp.domain.model.Meal

interface RecipeRepo {
    suspend fun getRecipeList(query: String): List<Meal>
}