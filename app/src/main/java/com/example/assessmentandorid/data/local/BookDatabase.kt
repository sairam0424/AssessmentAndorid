package com.example.assessmentandorid.data.local

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        fun getDatabase(application: Application): Any {

        }
    }
}

class Book {

}

annotation class Database(val entities: Any, val version: Int)
