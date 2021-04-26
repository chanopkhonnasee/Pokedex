package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class HeartgoldSoulsilver(
    @SerializedName("back_default")
    var backDefault: String?,
    @SerializedName("back_female")
    var backFemale: Any?,
    @SerializedName("back_shiny")
    var backShiny: String?,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any?,
    @SerializedName("front_default")
    var frontDefault: String?,
    @SerializedName("front_female")
    var frontFemale: Any?,
    @SerializedName("front_shiny")
    var frontShiny: String?,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any?
)