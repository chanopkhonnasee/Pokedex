package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class VersionGroup(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)