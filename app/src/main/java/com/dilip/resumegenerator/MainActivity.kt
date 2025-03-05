package com.dilip.resumegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dilip.resumegenerator.ui.ResumeGenerator
import com.dilip.resumegenerator.ui.components.PersonalDetails
import com.dilip.resumegenerator.ui.theme.ResumeGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResumeGeneratorTheme {
                val details = PersonalDetails(
                    name = "Dilip Patel",
                    email = "dilip@example.com",
                    phone = "+91 9876543210",
                    skills = listOf("Kotlin, Java, Android Development", "REST APIs, Firebase, MVVM", "Git, Github"),
                    projects = listOf("PropertyManager - Allows manage property between landlord, staff and tenant.")
                )
                ResumeGenerator(details)
            }
        }
    }
}

