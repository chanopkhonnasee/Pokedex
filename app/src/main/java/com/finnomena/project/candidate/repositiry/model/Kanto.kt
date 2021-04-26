package com.finnomena.project.candidate.repositiry.model


import com.google.gson.annotations.SerializedName

data class Kanto(
    @SerializedName("descriptions")
    var descriptions: List<Description>?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("is_main_series")
    var isMainSeries: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("names")
    var names: List<Name>?,
    @SerializedName("pokemon_entries")
    var pokemonEntries: List<PokemonEntry>?,
    @SerializedName("region")
    var region: Region?,
    @SerializedName("version_groups")
    var versionGroups: List<VersionGroup>?
)