package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("description")
    var description: String?,
    @SerializedName("language")
    var language: Language?
)