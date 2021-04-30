package com.finnomena.project.candidate.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finnomena.project.candidate.repositiry.Repository
import com.finnomena.project.candidate.repositiry.model.Kanto
import com.finnomena.project.candidate.repositiry.model.Pokemon
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val repository: Repository) : ViewModel() {

    /** live data **/
    val pokemonKanto = MutableLiveData<Kanto>()
    val pokemon = MutableLiveData<Pokemon>()

    fun getPokemonKanto() {
        repository.getPokemonKanto()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                pokemonKanto.value = it
            }, {
                Log.i("error", it.message.toString())
            })
    }

    fun getPokemon(keyword : String) {
        repository.getPokemon(keyword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                pokemon.value = it
            }, {
                Log.i("error", it.message.toString())
            })
    }
}