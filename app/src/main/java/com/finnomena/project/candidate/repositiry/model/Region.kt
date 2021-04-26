package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)