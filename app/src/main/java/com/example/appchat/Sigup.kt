package com.example.appchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Sigup : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPass: EditText
    private lateinit var btnSigup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigup)

        mAuth = FirebaseAuth.getInstance()

        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPass = findViewById(R.id.edt_pass)
        btnSigup = findViewById(R.id.btn_sigup)

        btnSigup.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPass.text.toString()

            signup(email,password)
        }

    }

    private fun signup(email: String, password: String) {
        //tao nguoi dung moi
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code chuyen sang trang chu

                    val intent = Intent(this@Sigup, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Sigup, "Bi loi", Toast.LENGTH_SHORT).show()
                }
            }

    }
}