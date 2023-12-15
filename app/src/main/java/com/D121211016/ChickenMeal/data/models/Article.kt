package com.D121211016.ChickenMeal.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Article(
    val strMeal: String?,
    val strMealThumb: String?,
    val idMeal: String?
): Parcelable