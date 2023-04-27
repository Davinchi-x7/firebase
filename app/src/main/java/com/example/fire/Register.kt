package com.example.fire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    lateinit var Name: EditText
    lateinit var Email: EditText
    lateinit var Password: EditText
    lateinit var Create: Button

    //initialize firebase
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Name = findViewById(R.id.full_name)
        Email = findViewById(R.id.email_add)
        Password = findViewById(R.id.password)
        Create = findViewById(R.id.create_btn)

        auth = FirebaseAuth.getInstance()

        //initialize firebase again


        Create.setOnClickListener {
            var name = Name.text.toString().trim()
            var email = Email.text.toString().trim()
            var password = Password.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)
                        finish()
                    } else {
                        Toast.makeText(this, "Failed to create user/check your internet connection", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }
}
