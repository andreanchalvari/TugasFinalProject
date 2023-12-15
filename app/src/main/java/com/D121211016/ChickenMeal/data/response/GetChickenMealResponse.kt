package com.D121211016.ChickenMeal.data.response

import com.D121211016.ChickenMeal.data.models.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetChickenMealResponse(
    @SerialName("meals")
    val meals: List<Article>?
)