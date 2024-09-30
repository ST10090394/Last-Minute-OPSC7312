package com.example.carspotteropsc7312poe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.example.carspotteropsc7312poe.activities.FirstActivity
import com.example.carspotteropsc7312poe.dataclass.Car
import com.example.carspotteropsc7312poe.location.MapboxActivity
import com.example.carspotteropsc7312poe.observation.ObservationActivity
import com.example.carspotteropsc7312poe.settings.SettingsActivity

class DashboardActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize UI elements
        val btnLogouts = findViewById<Button>(R.id.btnLogout)
        val btnLocateCars = findViewById<Button>(R.id.btnLocateCars)
        val btnObservations = findViewById<Button>(R.id.btnObservations)
        val btnExplore = findViewById<Button>(R.id.btnExplore)
        val btnKnowledge = findViewById<Button>(R.id.btnKnowledge)

        // Button click listeners

        // Logout button click listener
        btnLogouts.setOnClickListener()
        {
            btnSignOut() // Calls the function to sign out the user
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Redirects to the main activity (login page)
        }

        // Locate Cars button click listener
        btnLocateCars.setOnClickListener()
        {
            val intent = Intent(this, MapboxActivity::class.java)
            startActivity(intent) // Redirects to the Mapbox activity for locating cars
        }

        // Observations button click listener
        btnObservations.setOnClickListener()
        {
            val intent = Intent(this, ObservationActivity::class.java)
            startActivity(intent) // Redirects to the Observation activity
        }

        // Explore button click listener
        btnExplore.setOnClickListener()
        {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent) // Redirects to the settings activity
        }

        // Knowledge button click listener
        btnKnowledge.setOnClickListener()
        {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent) // Redirects to the knowledge activity
        }

        // Display a random car when the activity is created
        displayRandomCar()
    }

    // Car data
    private val Car = listOf(
        Car("Porsche Cayenne", "The Cayenne S is powered by a 4.0-litre biturbo V8 engine with a maximum power output of 349 kW (474 PS) and a drag torque of 600 Nm.", R.drawable.porsche),
        Car("Mercedes GLE", "The Mercedes-Benz GLE is a pinnacle of luxury, blending sophisticated design with unparalleled comfort.", R.drawable.mercedes_gle),
        Car("Ferrari F430", "he Ferrari F430 (Type F131) is a sports car produced by the Italian automobile manufacturer Ferrari from 2004 until 2009 as a successor to the Ferrari 360.", R.drawable.ferrari),
        Car("Rolls Royce Phantom", "The Phantom is a 5 seater 12 cylinder car and has length of 5982 mm, width of 2018 mm and a wheelbase of 3772 mm.", R.drawable.rolls_royce),
        Car("Bentley Bentayga", "This stunning Bentley long wheelbase vehicle combines cutting-edge technology with head-turning road presence and a 4.0 litre V8 engine", R.drawable.bentley_bentayga),
    )

    // Function to display a random car
    private fun displayRandomCar() {
        val randomIndex = (Car.indices).random()
        val randomCar = Car[randomIndex]

        // Update the ImageView
        val carImageView = findViewById<ImageView>(R.id.carImageView)
        carImageView.setImageResource(randomCar.imageResId)

        // Update the TextViews using the correct IDs
        val carNameTextView = findViewById<TextView>(R.id.carNameTextView) // Correct ID from XML
        val carDescriptionTextView = findViewById<TextView>(R.id.carDescriptionTextView) // Correct ID from XML
        carNameTextView.text = randomCar.name
        carDescriptionTextView.text = randomCar.description
    }

    // Function to sign out the user
    private fun btnSignOut() {
        Firebase.auth.signOut() // Sign out the user using Firebase Authentication
        Toast.makeText(this, "Goodbye User: Signed Out", Toast.LENGTH_LONG).show() // Display a toast message indicating the user is signed out
    }
}