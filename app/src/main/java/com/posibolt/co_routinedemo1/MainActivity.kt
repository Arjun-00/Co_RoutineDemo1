package com.posibolt.co_routinedemo1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var count = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countButton = findViewById<Button>(R.id.countButton)
        val downloadButton = findViewById<Button>(R.id.downloadButton)
        val tvCount = findViewById<TextView>(R.id.textViewCount)

        countButton.setOnClickListener {
            tvCount.text = count++.toString()
        }
        downloadButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }
        }
    }
    private fun downloadData(){
        for(i in 1..200000){
            Log.i("MyTag","Downloading User $i in ${Thread.currentThread().name}")
        }
    }
}