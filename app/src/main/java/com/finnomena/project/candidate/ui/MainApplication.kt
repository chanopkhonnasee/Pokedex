package com.finnomena.project.candidate.ui

import android.app.Application
import com.finnomena.project.candidate.repositiry.Repository
import com.finnomena.project.candidate.repositiry.RepositoryImpl
import com.finnomena.project.candidate.repositiry.service.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication: Application() {

    private val appModule = module {
        single<Repository>(createdAtStart = true) { RepositoryImpl(get()) } //createdAtStart
        viewModel { MainViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(apiModule, appModule)
        }
    }
}