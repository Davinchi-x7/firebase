package com.example.fire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var Log_email: EditText
    lateinit var Log_password: EditText
    lateinit var Log_btn: Button
    lateinit var Reg_btn: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log_email = findViewById(R.id.Mail_field)
        Log_password = findViewById(R.id.Pazz_field)
        Log_btn = findViewById(R.id.btn_login)
        Reg_btn = findViewById(R.id.btn_rg)
        auth = FirebaseAuth.getInstance()

        Log_btn.setOnClickListener {
            var email = Log_email.text.toString().trim()
            var password = Log_password.text.toString().trim()

//validate input
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "cant submit empty field", Toast.LENGTH_SHORT).show()
            } else {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    } else {

                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }
        Reg_btn.setOnClickListener {
            val start = Intent(this, Register::class.java)
            startActivity(start)
            finish()
        }
    }
}