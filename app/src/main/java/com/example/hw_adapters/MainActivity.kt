package com.example.hw_adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userList = findViewById<ListView>(R.id.userlist)
        val adapter = UserModelAdapter.build(this, R.layout.list_item)
        userList.adapter = adapter
    }
}