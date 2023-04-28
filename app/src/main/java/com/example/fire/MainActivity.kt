package com.example.fire

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var Make:EditText
    lateinit var C_Model:EditText
    lateinit var Price:EditText
    lateinit var upload_photo:Button
    lateinit var Upload_car_data:Button
    lateinit var btn_view:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Make = findViewById(R.id.edt_car_make)
        C_Model = findViewById(R.id.edt_car_model)
        Price = findViewById(R.id.edt_price)
        upload_photo = findViewById(R.id.btn_uploadphoto)
        Upload_car_data = findViewById(R.id.btn_uploaddetails)
        btn_view = findViewById(R.id.btn_viewcar)

        //initialize firebase
        var database = FirebaseDatabase.getInstance()
        var databaseReference = database.reference



        upload_photo.setOnClickListener {

        }
        Upload_car_data.setOnClickListener {

        }
        btn_view.setOnClickListener {

        }

       // btn_save_data.setOnClickListener {

       //     var user_data = edt_user_inp.text.toString().trim()
           // Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
       //     databaseReference.setValue(user_data)

       // }




    }
}