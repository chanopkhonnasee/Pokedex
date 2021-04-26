package com.finnomena.project.candidate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.finnomena.project.candidate.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    private var pokemonAdapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewData()
        initEvent()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.pokemonKanto.observe(this, Observer { kanto ->
            kanto.pokemonEntries?.let { pokemonEntry -> pokemonAdapter?.listData = pokemonEntry }
        })
    }

    private fun initEvent() {
        pokemonAdapter?.clickListener = { pokemonEntry ->
            val json = Gson().toJson(pokemonEntry)
            val bundle = Bundle()
            bundle.putString("pokemonEntry",json)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun initViewData() {
        pokemonAdapter = ListAdapter()
        listRecycler.adapter = pokemonAdapter

        viewModel.getPokemonKanto()
    }
}
