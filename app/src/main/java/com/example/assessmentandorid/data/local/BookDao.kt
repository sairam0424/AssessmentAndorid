package com.example.assessmentandorid.data.local
@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: List<Book>)

    @Query("SELECT * FROM book")
    suspend fun getAllBooks(): List<Book>
}
