package com.example.findmyservicep2

class UserModels {

    data class ServiceProvider(
        val id: String,
        val name: String,
        val idNumber: String,
        val profilePictureUrl: String,
        val certificates: List<String>,
        val experiences: List<String>
    )

    data class Client(
        val id: String,
        val name: String,
        val idNumber: String,
        val profilePictureUrl: String
    )

}