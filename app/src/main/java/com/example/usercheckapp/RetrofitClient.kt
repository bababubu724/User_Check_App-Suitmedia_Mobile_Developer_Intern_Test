package com.example.usercheckapp

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://reqres.in/api/"
    private const val API_KEY = "reqres-free-v1"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            // Menambahkan header x-api-key pada setiap permintaan
            val originalRequest: Request = chain.request()
            val requestWithApiKey = originalRequest.newBuilder()
                .header("x-api-key", API_KEY)
                .build()

            // Melanjutkan permintaan dengan header yang sudah ditambahkan
            chain.proceed(requestWithApiKey)
        }
        .build()

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
