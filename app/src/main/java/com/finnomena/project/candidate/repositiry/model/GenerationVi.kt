package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire?,
    @SerializedName("x-y")
    var xY: XY?
)