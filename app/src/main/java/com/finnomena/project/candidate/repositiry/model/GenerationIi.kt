package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class GenerationIi(
    @SerializedName("crystal")
    var crystal: Crystal?,
    @SerializedName("gold")
    var gold: Gold?,
    @SerializedName("silver")
    var silver: Silver?
)