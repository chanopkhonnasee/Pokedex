package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("language")
    var language: LanguageX?,
    @SerializedName("name")
    var name: String?
)