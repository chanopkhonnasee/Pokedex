package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Crystal(
    @SerializedName("back_default")
    var backDefault: String?,
    @SerializedName("back_shiny")
    var backShiny: String?,
    @SerializedName("front_default")
    var frontDefault: String?,
    @SerializedName("front_shiny")
    var frontShiny: String?
)