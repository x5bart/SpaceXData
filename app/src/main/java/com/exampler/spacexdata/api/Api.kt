package com.exampler.spacexdata.api

import com.exampler.spacexdata.model.CurrentLauncher
import retrofit2.Call
import retrofit2.http.GET


internal interface Api {
    @get:GET("launches")
    val json: Call<List<CurrentLauncher>>
}