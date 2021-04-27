package com.finnomena.project.candidate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        //TODO splash screen
        //TODO loading
    }

    private fun initViewModel() {
        viewModel.pokemonKanto.observe(this, Observer { kanto ->
            kanto.pokemonEntries?.let { pokemonEntry -> pokemonAdapter?.listData = pokemonEntry }
        })
        viewModel.pokemon.observe(this, Observer { pokemon ->
            pokemonAdapter?.listData?.find { it.entryNumber == pokemon.id }?.frontDefault = pokemon.sprites?.frontDefault
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
        btn_search.setOnClickListener {
            val textSearch = tv_search.text.toString()
            val number = viewModel.pokemonKanto.value?.pokemonEntries?.find { it.pokemonSpecies?.name == textSearch || it.entryNumber.toString() == textSearch }?.entryNumber?.toInt()
            if(number!=null){
                pokemonAdapter?.focusPosition(number-1)
                listRecycler.scrollToPosition(number-1)
            } else {
                Toast.makeText(this,"Pokemon not found",Toast.LENGTH_SHORT)
            }
        }
    }

    private fun initViewData() {
        pokemonAdapter = ListAdapter(this)
        listRecycler.adapter = pokemonAdapter

        viewModel.getPokemonKanto()
    }

    override fun onResume() {
        super.onResume()

        pokemonAdapter?.notifyDataSetChanged()
    }
}
