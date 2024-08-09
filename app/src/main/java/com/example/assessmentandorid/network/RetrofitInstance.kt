package com.example.assessmentandorid.network

object RetrofitInstance {
    private const val BASE_URL = "https://example.com/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}