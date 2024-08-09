package com.example.assessmentandorid

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentandorid.ui.adapter.BookAdapter

class MainActivity<BookViewModel : Any> : AppCompatActivity() {
    private lateinit var viewModel: BookViewModel
    private lateinit var bookAdapter: BookAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        viewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        viewModel.fetchBooks()

        viewModel.getBooks().observe(this, Observer { books ->
            bookAdapter = BookAdapter(books)
            recyclerView.adapter = bookAdapter
            progressBar.visibility = View.GONE
        })

        // Show progress bar while loading
        progressBar.visibility = View.VISIBLE
    }
}
