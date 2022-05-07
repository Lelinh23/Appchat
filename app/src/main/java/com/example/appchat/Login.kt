package com.example.appchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSigup: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edt_email)
        edtPass = findViewById(R.id.edt_pass)
        btnLogin = findViewById(R.id.btn_login)
        btnSigup = findViewById(R.id.btn_sigup)

        btnSigup.setOnClickListener {
            var intent = Intent(this, Sigup::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPass.text.toString()

            login(email,password)
        }
    }

    private fun login(email: String, password: String) {
        // nguoi dung login

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code nguoi dung login

                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Nguoi dung khong ton tai", Toast.LENGTH_SHORT).show()
                }
            }

    }
}