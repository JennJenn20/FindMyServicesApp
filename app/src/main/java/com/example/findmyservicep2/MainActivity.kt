package com.example.findmyservicep2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button by its ID
        val buttonMoveToLoginPage: Button = findViewById(R.id.MovetoLoginPage)

// Set up an OnClickListener for the button
        buttonMoveToLoginPage.setOnClickListener {
            // Create an Intent to start the new activity
            val intent = Intent(this, LoginActivity::class.java)
            // Start the new activity
            startActivity(intent)
        }

        // Find the button by its ID
        val buttonMoveToSignUpPage: Button = findViewById(R.id.MovetoSignUpPage)

// Set up an OnClickListener for the button
        buttonMoveToSignUpPage.setOnClickListener {
            // Create an Intent to start the new activity
            val intent = Intent(this, SignUpActivity::class.java)
            // Start the new activity
            startActivity(intent)
        }

    }
}