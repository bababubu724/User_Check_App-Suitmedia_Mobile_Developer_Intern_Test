package com.example.usercheckapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.first_screen)

        // Menghubungkan EditText dan Button dengan ID dari XML
        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val palindromeEditText = findViewById<EditText>(R.id.editTextPalindrome)
        val checkButton = findViewById<Button>(R.id.buttonCheck)
        val nextButton = findViewById<Button>(R.id.buttonNext)

        // Tombol Check untuk memeriksa apakah kalimat adalah palindrome
        checkButton.setOnClickListener {
            val sentence = palindromeEditText.text.toString().replace(" ", "").lowercase()
            val isPalindrome = sentence == sentence.reversed()
            val message = if (isPalindrome) "isPalindrome" else "not palindrome"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        // Tombol Next untuk navigasi ke layar kedua (SecondScreen)
        nextButton.setOnClickListener {
            val intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("NAME", nameEditText.text.toString())
            startActivity(intent)
        }
    }
}
