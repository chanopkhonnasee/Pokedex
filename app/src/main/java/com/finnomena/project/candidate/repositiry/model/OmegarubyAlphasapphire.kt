package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class OmegarubyAlphasapphire(
    @SerializedName("front_default")
    var frontDefault: String?,
    @SerializedName("front_female")
    var frontFemale: Any?,
    @SerializedName("front_shiny")
    var frontShiny: String?,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any?
)