package com.example.loginsqlite

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginsqlite.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.signupButton.setOnClickListener() {
            val email = binding.signupEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confirmPassword = binding.signupConfirm.text.toString()

            if (email.equals("") || password.equals("") || confirmPassword.equals(""))
                Toast.makeText(this@SignupActivity, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            else {
                if (password.equals(confirmPassword)){
                    val checkUserEmail = databaseHelper.checkEmail(email)

                    if (checkUserEmail == false){
                        val insert = databaseHelper.insertData(email, password)

                        if (insert == true){
                            Toast.makeText(this@SignupActivity, "Signup Successfully", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignupActivity, SigninActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignupActivity, "Signup Failed", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@SignupActivity, "User already exists. Please sign in", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@SignupActivity, "Invalid password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.SignInRedirectText.setOnClickListener() {
            val intent = Intent(this@SignupActivity, SigninActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}