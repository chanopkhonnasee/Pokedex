package com.finnomena.project.candidate.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.finnomena.project.candidate.R
import com.finnomena.project.candidate.repositiry.model.PokemonEntry
import com.gisc.track.util.SharedPrefsUtil
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {


    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showLoading()
        initViewData()
        initEvent()
    }

    private fun initEvent() {
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initViewModel(entryNumber: Int) {
        viewModel.getPokemon(entryNumber.toString())
        viewModel.pokemon.observe(this, Observer { pokemon ->
            tvPokemonName.text = pokemon.name
            loadImage(pokemon.sprites?.frontDefault,ivPokemonImg,pokemon.name!!)
            tvPokemonHeight.text = "Height : "+pokemon.height.toString()
            tvPokemonWeight.text = "Weight : "+pokemon.weight.toString()
            tvPokemonTypes.text = "Types : "+pokemon.types?.map { it.type?.name }.toString().replace("[","").replace("]","")
            pokemon.stats?.forEach {
                when(it.stat?.name) {
                    "hp" -> { tvhp.text = it.baseStat.toString() }
                    "attack" -> { tvattack.text = it.baseStat.toString() }
                    "special-attack" -> { tvspecial_attack.text = it.baseStat.toString() }
                    "defense" -> { tvdefense.text = it.baseStat.toString() }
                    "special-defense" -> { tvspecial_defense.text = it.baseStat.toString() }
                    "speed" -> { tvspeed.text = it.baseStat.toString() }
                }
            }
            hideLoading()
        })
    }

    private fun initViewData() {
        val bundle = intent.extras
        bundle?.let{
            val json = bundle.getString("pokemonEntry")
            val data = Gson().fromJson(json, PokemonEntry::class.java)
            if(data.entryNumber != null) {
                initViewModel(data.entryNumber!!)
            } else {
                onBackPressed()
            }
        }
    }

    private fun loadImage(url: String?,view: ImageView, name: String) {
        if (url != null && url.isNotBlank()) {
            Glide.with(this)
                .load(url)
                .into(view)
            SharedPrefsUtil.setString(this,name,url)
        }
    }

    fun showLoading() {
        frlProgressBar?.visibility = View.VISIBLE
    }

    fun hideLoading() {
        frlProgressBar?.visibility = View.GONE
    }
}