package com.finnomena.project.candidate.repositiry

import com.finnomena.project.candidate.repositiry.model.Kanto
import io.reactivex.rxjava3.core.Observable

interface Repository {
    fun getPokemonKanto(): Observable<Kanto>
}