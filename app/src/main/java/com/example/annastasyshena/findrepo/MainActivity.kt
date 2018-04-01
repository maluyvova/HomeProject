package com.example.annastasyshena.findrepo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.VisibleForTesting
import android.widget.Button
import android.widget.EditText
import android.support.test.espresso.IdlingResource
import android.support.test.espresso.idling.CountingIdlingResource


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText = findViewById<EditText>(R.id.SearchEditText)
        val userReoEditText = findViewById<EditText>(R.id.userRepoEditText)

        val button = findViewById<Button>(R.id.searchButton)
        button.setOnClickListener {
            val intent = Intent(this, SearchResultActivity::class.java)
            intent.putExtra("searchTerm", searchEditText.text.toString())
            startActivity(intent)
        }
        val viewRepoButton = findViewById<Button>(R.id.userRepoButton)
        viewRepoButton.setOnClickListener{
            val intent = Intent(this, SearchResultActivity::class.java)
            intent.putExtra("username", userReoEditText.text.toString())
            startActivity(intent)
        }
    }
}
