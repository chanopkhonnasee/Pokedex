package com.finnomena.project.candidate.ui

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
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {


    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViewModel()
        initViewData()
        initEvent()
    }

    private fun initEvent() {
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initViewModel() {
        viewModel.pokemon.observe(this, Observer { pokemon ->
            ivPokemonName.text = pokemon.name
            loadImage(pokemon.sprites?.frontDefault,ivPokemonImg)
        })
    }

    private fun initViewData() {
        val bundle = intent.extras
        bundle?.let{
            val json = bundle.getString("pokemonEntry")
            val data = Gson().fromJson(json, PokemonEntry::class.java)
            //TODO check null
            viewModel.getPokemon(data.entryNumber.toString())
        }
    }

    private fun loadImage(url: String?,view: ImageView) {
        if (url != null && url.isNotBlank()) {

            Glide.with(this)
                .load(url)
                .into(view)
        }
    }
}