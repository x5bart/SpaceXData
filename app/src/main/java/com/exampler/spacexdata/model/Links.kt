package com.exampler.spacexdata.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("mission_patch_small") var image: String,
    @SerializedName("video_link") var video: String,
    @SerializedName("flickr_images") val flickrImage: ArrayList<String>
)

