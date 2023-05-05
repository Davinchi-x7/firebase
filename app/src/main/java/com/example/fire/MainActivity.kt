package com.example.fire

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    lateinit var Make:EditText
    lateinit var C_Model:EditText
    lateinit var Price:EditText
    lateinit var upload_photo:Button
    lateinit var Upload_car_data:Button
    lateinit var btn_view:Button
    lateinit var dk_mode:Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Make = findViewById(R.id.edt_car_make)
        C_Model = findViewById(R.id.edt_car_model)
        Price = findViewById(R.id.edt_price)
        upload_photo = findViewById(R.id.btn_uploadphoto)
        Upload_car_data = findViewById(R.id.btn_uploaddetails)
        btn_view = findViewById(R.id.btn_viewcar)
        dk_mode = findViewById(R.id.dk_mode_switch)
        //initialize firebase
          var database = FirebaseDatabase.getInstance()
          var databaseRef = database.getReference("Cars")





        upload_photo.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        Upload_car_data.setOnClickListener {
            var carmake = Make.text.toString().trim()
            var carmodel = C_Model.text.toString().trim()
            var carprice = Price.text.toString().trim()

            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()){
                Toast.makeText(this, "cannot submit an empty field", Toast.LENGTH_SHORT).show()
            }else{
                //saving info to firebase db
                var usercar = CAR(carmake,carmodel,carprice)
                var ref = FirebaseDatabase.getInstance().getReference().child("Cars")
                
                ref.setValue(usercar).addOnCompleteListener(){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Car Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        btn_view.setOnClickListener {
            var view = Intent(this,Db_view_items::class.java)
            startActivity(view)
            finish()
        }

       // btn_save_data.setOnClickListener {

       //     var user_data = edt_user_inp.text.toString().trim()
           // Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
       //     databaseReference.setValue(user_data)

       // }


        dk_mode.setOnClickListener {

        }

    }
}