package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class PokemonEntry(
    @SerializedName("entry_number")
    var entryNumber: Int?,
    @SerializedName("pokemon_species")
    var pokemonSpecies: PokemonSpecies?,
    @SerializedName("front_default")
    var frontDefault: String?
)