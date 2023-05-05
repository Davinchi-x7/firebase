package com.example.fire

import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class `Files list activity` : AppCompatActivity(){
    private lateinit var listView: ListView
    private lateinit var fileNames: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>
}