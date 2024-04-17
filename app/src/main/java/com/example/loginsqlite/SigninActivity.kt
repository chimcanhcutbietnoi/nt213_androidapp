package com.example.loginsqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginsqlite.databinding.ActivitySignin3Binding

class SigninActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignin3Binding
    lateinit var databaseHelper: DatabaseHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignin3Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.signinButton.setOnClickListener(){
            val email = binding.signinEmail.text.toString()
            val password = binding.signinPassword.text.toString()

            if (email.equals("") || password.equals(""))
                Toast.makeText(this@SigninActivity, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            else {
                val checkCredentials = databaseHelper.checkEmailPassword(email, password)

                if (checkCredentials == true){
                    Toast.makeText(this@SigninActivity, "Sign in successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SigninActivity, MainActivity::class.java)
                    intent.putExtra("UserName", email)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SigninActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.signinredirecttext.setOnClickListener() {
            val intent = Intent(this@SigninActivity, SignupActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}