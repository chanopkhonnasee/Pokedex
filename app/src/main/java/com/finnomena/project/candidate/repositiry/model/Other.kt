package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    var dreamWorld: DreamWorld?,
    @SerializedName("official-artwork")
    var officialArtwork: OfficialArtwork?
)