package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    var diamondPearl: DiamondPearl?,
    @SerializedName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver?,
    @SerializedName("platinum")
    var platinum: Platinum?
)