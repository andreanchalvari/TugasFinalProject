package com.D121211016.ChickenMeal.data.repository

import com.D121211016.ChickenMeal.data.response.GetChickenMealResponse
import com.D121211016.ChickenMeal.data.source.remote.ApiService

class ChickenMealRepository(private val apiService: ApiService) {

    suspend fun getPasta(c: String): GetChickenMealResponse {
        return apiService.getChickenMeal(c)
    }
}