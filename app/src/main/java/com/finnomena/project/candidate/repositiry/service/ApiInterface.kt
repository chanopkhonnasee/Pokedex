package com.finnomena.project.candidate.repositiry.service

import com.finnomena.project.candidate.repositiry.model.Kanto
import com.finnomena.project.candidate.repositiry.model.Pokemon
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/v2/pokedex/2/")
    fun getPokemonKanto(): Observable<Kanto>

    @GET("/api/v2/pokemon/{keyword}")
    fun getPokemon(@Path("keyword") keyword: String): Observable<Pokemon>
}
