package com.example.fire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Db_view_items : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var fileNames: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_view_items)

        listView = findViewById(R.id.l_view)

        val db = FirebaseDatabase.getInstance()
        var databaseRef = db.getReference("Cars")
        databaseRef.child("cars").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                fileNames = mutableListOf()


        for (fileSnapshot in snapshot.children){
            val fileName = fileSnapshot.key
            fileNames.add(fileName!!)
        }

          adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, fileNames)
          listView.adapter = adapter

    }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(applicationContext, "failed to retrieve files: $(error.message)", Toast.LENGTH_SHORT).show()
            }
        })
    }
}