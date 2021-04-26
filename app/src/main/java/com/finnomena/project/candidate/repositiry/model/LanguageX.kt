package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class LanguageX(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)