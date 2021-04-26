package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Move(
    @SerializedName("move")
    var move: MoveX?,
    @SerializedName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail>?
)