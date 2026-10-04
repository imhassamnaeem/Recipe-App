package com.example.recipeapp.data.remote.api

import com.example.recipeapp.data.remote.dto.MealResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {
    @GET("search.php?")
    suspend fun getMealList(@Query("s") s: String): MealResponseDto
}