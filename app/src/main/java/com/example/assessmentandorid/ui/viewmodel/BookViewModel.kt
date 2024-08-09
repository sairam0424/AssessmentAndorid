package com.example.assessmentandorid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.assessmentandorid.data.local.BookDatabase
import com.example.assessmentandorid.data.model.Book
import com.example.assessmentandorid.data.repository.BookRepository
import com.example.assessmentandorid.network.RetrofitInstance

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BookRepository

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        val apiService = RetrofitInstance.api
        repository = BookRepository(bookDao, apiService)
    }

//    fun fetchBooks() {
//        val viewModelScope
//        viewModelScope.launch {
//            repository.fetchBooks()
//        }
//    }

    fun getBooks(): LiveData<List<Book>> {
        // Return LiveData from Room
    }
}
