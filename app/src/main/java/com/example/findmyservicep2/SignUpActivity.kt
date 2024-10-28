package com.example.findmyservicep2

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SignUpActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 1001
    private val CAMERA_PERMISSION_CODE = 1002

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        val radioGroupUserType = findViewById<RadioGroup>(R.id.radioGroupUserType)
        val buttonSignUpMoveToLogin = findViewById<Button>(R.id.btnsignupmovetologin)

        buttonSignUpMoveToLogin.setOnClickListener {
            val selectedUserTypeId = radioGroupUserType.checkedRadioButtonId
            if (selectedUserTypeId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedUserTypeId)
                val userType = selectedRadioButton.text.toString()

                if (userType == "Service Provider") {
                    val intent = Intent(this, ServiceProviderDetailsActivity::class.java)
                    startActivity(intent)
                } else if (userType == "Client") {
                    val intent = Intent(this, ServiceCatActivity::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Please select a user type", Toast.LENGTH_SHORT).show()
            }
        }

        // Camera verification
        findViewById<Button>(R.id.cameraButton).setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
            } else {
                openCamera()
            }
        }

        // Find the button by its ID
        val buttonMoveBackToGetStartedPage: Button = findViewById(R.id.btnbacktogetstarted)
        buttonMoveBackToGetStartedPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(this, "Camera permission is required to use the camera", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap
            // Save or display the photo
        }
    }

    private fun performBackgroundCheck(idNumber: String, profilePicture: Bitmap) {
        // Call third-party service for background check
        // Example: BackgroundCheckService.verify(idNumber, profilePicture)
    }
}