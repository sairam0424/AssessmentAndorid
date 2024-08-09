package com.example.assessmentandorid.data.repository

class BookRepository(private val bookDao: BookDao, private val apiService: BookApiService) {
    suspend fun fetchBooks() {
        try {
            val books = apiService.getBooks()
            bookDao.insertBooks(books)
        } catch (e: Exception) {
            // Handle exception
        }
    }

    suspend fun getBooksFromDb(): List<Book> {
        return bookDao.getAllBooks()
    }
}
