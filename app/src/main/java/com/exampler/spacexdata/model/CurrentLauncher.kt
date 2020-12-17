package com.exampler.spacexdata.model

import com.google.gson.annotations.SerializedName

data class CurrentLauncher(
    @SerializedName("mission_name") var missionName: String,
    @SerializedName("launch_date_utc") var date: String,
    @SerializedName("flight_number") var id: Int,
    var details :String,
    var rocket: Rocket,
    var links: Links


)
