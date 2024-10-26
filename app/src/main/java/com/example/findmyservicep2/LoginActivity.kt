package com.example.findmyservicep2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            // Find the button by its ID
            val buttonMoveBackToGetStartedPage: Button = findViewById(R.id.btnbacktogetstarted)

// Set up an OnClickListener for the button
//
            buttonMoveBackToGetStartedPage.setOnClickListener {
                // Create an Intent to start the new activity
                val intent = Intent(this, MainActivity::class.java)
                // Start the new activity
                startActivity(intent)
            }
        }
    }