package com.D121211016.ChickenMeal.data.source.remote

import com.D121211016.ChickenMeal.data.response.GetChickenMealResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    // https://www.themealdb.com/api/json/v1/1/filter.php?c=Chicken

    @GET("api/json/v1/1/filter.php")
    suspend fun getChickenMeal(
        @Query("c") c: String
    ): GetChickenMealResponse
}