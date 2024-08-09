package com.example.assessmentandorid.network

interface BookApiService {
    @GET("api/books")
    suspend fun getBooks(): List<Book>
}