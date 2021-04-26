package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class GenerationIii(
    @SerializedName("emerald")
    var emerald: Emerald?,
    @SerializedName("firered-leafgreen")
    var fireredLeafgreen: FireredLeafgreen?,
    @SerializedName("ruby-sapphire")
    var rubySapphire: RubySapphire?
)