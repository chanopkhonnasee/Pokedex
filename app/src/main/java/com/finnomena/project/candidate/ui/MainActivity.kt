package com.finnomena.project.candidate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finnomena.project.candidate.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPokemonKanto()
    }
}
