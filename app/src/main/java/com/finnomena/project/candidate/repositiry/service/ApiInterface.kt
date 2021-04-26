package com.finnomena.project.candidate.repositiry.service

import com.finnomena.project.candidate.repositiry.model.Kanto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/v2/pokedex/2/")
    fun getPokemonKanto(): Observable<Kanto>
}
