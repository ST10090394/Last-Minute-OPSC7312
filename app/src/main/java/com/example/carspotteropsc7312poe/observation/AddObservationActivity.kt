package com.example.carspotteropsc7312poe.observation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.FirebaseApp
import com.example.carspotteropsc7312poe.DashboardActivity
import com.example.carspotteropsc7312poe.MainActivity
import com.example.carspotteropsc7312poe.R
import com.example.carspotteropsc7312poe.databinding.ActivityAddObservationBinding
import com.example.carspotteropsc7312poe.dataclass.UserObservation
import com.example.carspotteropsc7312poe.location.MapboxActivity

class AddObservationActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityAddObservationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddObservationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance().reference
        FirebaseApp.initializeApp(this)

        // Save observation button click
        binding.btnSave.setOnClickListener {
            saveObservation()
        }

        // Set OnClickListener for the button
        val buttonAddObservation = findViewById<Button>(R.id.btnback)
        buttonAddObservation.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    // Add the missing navigateToMainActivity method
    fun navigateToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saveObservation() {
        val CarName = binding.etCarName.text.toString()
        val Model = binding.etModel.text.toString()
        val CarDescription = binding.etCarDescription.text.toString()
        val longitudeText = binding.etLongitude.text.toString()
        val latitudeText = binding.etLatitude.text.toString()
        val imageUrl = binding.etImageUrl.text.toString()

        // Input validation
        if (CarName.isBlank() || Model.isBlank() || CarDescription.isBlank() || imageUrl.isBlank()) {
            showToast("Please fill in all the required fields.")
            return
        }

        val longitude = longitudeText.toDoubleOrNull()
        val latitude = latitudeText.toDoubleOrNull()

        if (longitude == null || latitude == null) {
            showToast("Invalid longitude or latitude. Please enter valid numbers.")
            return
        }

        val observation = UserObservation(
            CarName = CarName,
            Model = Model,
            CarDescription = CarDescription,
            longitude = longitude,
            latitude = latitude,
            imageUrl = imageUrl
        )

        // Save to Firebase
        val observationRef = database.child("observations").push()
        observationRef.setValue(observation)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showToast("Observation saved successfully!")

                    // Pass latitude and longitude to MapboxActivity
                    val intent = Intent(this, MapboxActivity::class.java)
                    intent.putExtra("latitude", observation.latitude)
                    intent.putExtra("longitude", observation.longitude)
                    startActivity(intent)
                } else {
                    showToast("Failed to save observation. Please try again.")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
