package com.example.loginsqlite

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inflate the navigation drawer layout
        val navigationDrawerLayout = LayoutInflater.from(this).inflate(R.layout.nav_draw, null)

        val usernameTextView = findViewById<TextView>(R.id.usernameTextView)

        val userName = intent.getStringExtra("UserName")

        val capitalizedUserName = userName?.uppercase() // Convert username to uppercase
        usernameTextView.text = capitalizedUserName

        // Set OnClickListener to handle logout confirmation
        findViewById<ImageView>(R.id.logoutTextView).setOnClickListener {
            showLogoutConfirmationDialog()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showLogoutConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Logout")
        alertDialog.setMessage("Are you sure you want to logout?")
        alertDialog.setPositiveButton("Yes") { dialogInterface: DialogInterface, _: Int ->
            // Implement your logout logic here
            val intent = Intent(this@MainActivity, SigninActivity::class.java)
            startActivity(intent)
            finish() // Finish current activity to prevent going back to it after logging out
            dialogInterface.dismiss()
        }
        alertDialog.setNegativeButton("No") { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
        }
        alertDialog.show()
    }
}
