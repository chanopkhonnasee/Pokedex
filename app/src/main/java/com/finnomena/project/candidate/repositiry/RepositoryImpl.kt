package com.finnomena.project.candidate.repositiry


import com.finnomena.project.candidate.repositiry.model.Kanto
import com.finnomena.project.candidate.repositiry.model.Pokemon
import com.finnomena.project.candidate.repositiry.service.ApiInterface
import io.reactivex.rxjava3.core.Observable

class RepositoryImpl(private val dataSource: ApiInterface) : Repository {
    override fun getPokemonKanto(): Observable<Kanto> {
        return dataSource.getPokemonKanto()
    }

    override fun getPokemon(keyword: String): Observable<Pokemon> {
        return dataSource.getPokemon(keyword)
    }
}