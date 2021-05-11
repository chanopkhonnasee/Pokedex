package com.finnomena.project.candidate.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.finnomena.project.candidate.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.frlProgressBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    private var pokemonAdapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLoading()
        initViewData()
        initEvent()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getPokemonKanto()
        viewModel.pokemonKanto.observe(this, Observer { kanto ->
            kanto.pokemonEntries?.let { pokemonEntry -> pokemonAdapter?.listData = pokemonEntry }
            hideLoading()
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
        tv_search.addTextChangedListener {
            val textSearch = tv_search.text.toString()
            if (it.toString() == "") {
                viewModel.pokemonKanto.value?.pokemonEntries?.let { pokemonEntry -> pokemonAdapter?.listData = pokemonEntry }
            } else {
                viewModel.pokemonKanto.value?.pokemonEntries?.filter { it.pokemonSpecies?.name?.contains(textSearch) ?: false || it.entryNumber.toString().contains(textSearch)  }?.apply {
                    pokemonAdapter?.listData = this
                }
            }
        }
//        btn_search.setOnClickListener {
//            val textSearch = tv_search.text.toString()
//            val number = viewModel.pokemonKanto.value?.pokemonEntries?.find { it.pokemonSpecies?.name == textSearch || it.entryNumber.toString() == textSearch }?.entryNumber?.toInt()
//            if(number!=null){
//                pokemonAdapter?.focusPosition(number-1)
//                listRecycler.scrollToPosition(number-1)
//            } else {
//                Toast.makeText(this,"Pokemon not found",Toast.LENGTH_SHORT)
//            }
//        }
    }

    private fun initViewData() {
        pokemonAdapter = ListAdapter(this)
        listRecycler.adapter = pokemonAdapter
    }

    override fun onResume() {
        super.onResume()
        pokemonAdapter?.notifyDataSetChanged()
    }

    fun showLoading() {
        frlProgressBar?.visibility = View.VISIBLE
    }

    fun hideLoading() {
        frlProgressBar?.visibility = View.GONE
    }
}
