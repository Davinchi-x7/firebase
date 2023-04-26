package com.example.fire

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var edt_user_inp:EditText
    lateinit var btn_save_data:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_user_inp = findViewById(R.id.EDT_TXT)
        btn_save_data = findViewById(R.id.btn_1)

        //initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseReference = database.reference



        btn_save_data.setOnClickListener {

            var user_data = edt_user_inp.text.toString().trim()
           // Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
            databaseReference.setValue(user_data)

        }
    }
}