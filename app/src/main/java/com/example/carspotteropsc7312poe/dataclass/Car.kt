package com.example.carspotteropsc7312poe.dataclass

data class Car(val name: String,
               val description: String,
               val imageResId: Int) {

    // Ensure that the image resource ID is a valid resource
    init {
        if (imageResId <= 0) {
            throw IllegalArgumentException("Invalid image resource ID: $imageResId. It should be a valid resource ID.")
        }
    }
}