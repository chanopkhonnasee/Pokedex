package com.finnomena.project.candidate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.finnomena.project.candidate.R
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

    }

    private fun initViewData() {
        pokemonAdapter = ListAdapter()
        listRecycler.adapter = pokemonAdapter

        viewModel.getPokemonKanto()
    }
}
