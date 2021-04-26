package com.finnomena.project.candidate.repositiry

import com.finnomena.project.candidate.repositiry.model.Kanto
import com.finnomena.project.candidate.repositiry.model.Pokemon
import io.reactivex.rxjava3.core.Observable

interface Repository {
    fun getPokemonKanto(): Observable<Kanto>

    fun getPokemon(keyword: String): Observable<Pokemon>
}