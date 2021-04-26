package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("abilities")
    var abilities: List<Ability>?,
    @SerializedName("base_experience")
    var baseExperience: Int?,
    @SerializedName("forms")
    var forms: List<Form>?,
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice>?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("held_items")
    var heldItems: List<Any>?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("is_default")
    var isDefault: Boolean?,
    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String?,
    @SerializedName("moves")
    var moves: List<Move>?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("order")
    var order: Int?,
    @SerializedName("past_types")
    var pastTypes: List<Any>?,
    @SerializedName("species")
    var species: Species?,
    @SerializedName("sprites")
    var sprites: Sprites?,
    @SerializedName("stats")
    var stats: List<Stat>?,
    @SerializedName("types")
    var types: List<Type>?,
    @SerializedName("weight")
    var weight: Int?
)