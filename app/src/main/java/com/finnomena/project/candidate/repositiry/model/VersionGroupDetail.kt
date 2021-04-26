package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    var levelLearnedAt: Int?,
    @SerializedName("move_learn_method")
    var moveLearnMethod: MoveLearnMethod?,
    @SerializedName("version_group")
    var versionGroup: VersionGroupX?
)