package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    var blackWhite: BlackWhite?
)