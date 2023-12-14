package com.D121211016.ChickenMeal

import android.app.Application
import com.D121211016.ChickenMeal.data.AppContainer
import com.D121211016.ChickenMeal.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}