package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("slot")
    var slot: Int?,
    @SerializedName("type")
    var type: TypeX?
)