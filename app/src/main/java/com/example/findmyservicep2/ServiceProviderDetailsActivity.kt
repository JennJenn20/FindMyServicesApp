package com.example.findmyservicep2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ServiceProviderDetailsActivity : AppCompatActivity() {

    private val PICK_CERTIFICATIONS_REQUEST_CODE = 1001
    private var certificationsUri: Uri? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider_details)

        val btnUploadCertifications = findViewById<Button>(R.id.btnUploadCertifications)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnUploadCertifications.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "application/pdf"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(intent, PICK_CERTIFICATIONS_REQUEST_CODE)
        }

        btnSubmit.setOnClickListener {
            val references = findViewById<EditText>(R.id.etReferences).text.toString()
            val serviceDetails = findViewById<EditText>(R.id.etServiceDetails).text.toString()
            val prices = findViewById<EditText>(R.id.etPrices).text.toString()

            if (certificationsUri == null && references.isEmpty()) {
                Toast.makeText(this, "Please upload certifications or enter references", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Handle form submission logic here
            // Save the details to the database or send them to a server

            Toast.makeText(this, "Details submitted successfully", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_CERTIFICATIONS_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            certificationsUri = data?.data
            Toast.makeText(this, "Certifications uploaded successfully", Toast.LENGTH_SHORT).show()
        }
    }
}