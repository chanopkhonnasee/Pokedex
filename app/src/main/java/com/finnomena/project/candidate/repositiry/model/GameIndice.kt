package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int?,
    @SerializedName("version")
    var version: Version?
)