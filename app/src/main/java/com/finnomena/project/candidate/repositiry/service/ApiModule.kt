package com.finnomena.project.candidate.repositiry.service

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    single { provideOkHttpClient(androidContext()) }
    single<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }
    single<Converter.Factory> { GsonConverterFactory.create() }
    single { provideApiService(get(),get(),get())}
}

fun provideOkHttpClient(context: Context): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor.Builder(context).build())
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

fun provideApiService(okHttpClient: OkHttpClient, rxJava3CallAdapterFactory : CallAdapter.Factory, gsonConverterFactory : Converter.Factory): ApiInterface {
    return Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .addCallAdapterFactory(rxJava3CallAdapterFactory)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(ApiInterface::class.java)

}