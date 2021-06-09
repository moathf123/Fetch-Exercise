package com.example.fetchexercise.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface HiringListService {
    @GET("hiring.json")
    fun getHiringlist(): Deferred<NetworkHiringContainer>
}

/**
 * Build the Moshi object that Retrofit will be using
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Main entry point for network access
 */
object Network {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/hiring.json")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val Hirings = retrofit.create(HiringListService::class.java)
}
