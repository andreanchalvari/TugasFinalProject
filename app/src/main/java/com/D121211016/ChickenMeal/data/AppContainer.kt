package com.D121211016.ChickenMeal.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.D121211016.ChickenMeal.data.repository.ChickenMealRepository
import com.D121211016.ChickenMeal.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val ChickenMealRepository: ChickenMealRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://www.themealdb.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val ChickenMealRepository: ChickenMealRepository
        get() = ChickenMealRepository(retrofitService)

}