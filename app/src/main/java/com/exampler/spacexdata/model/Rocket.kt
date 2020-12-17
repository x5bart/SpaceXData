package com.exampler.spacexdata.model

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("rocket_name") var rocketName: String,
)
