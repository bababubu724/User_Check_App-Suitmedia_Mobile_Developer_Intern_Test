package com.example.usercheckapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        // Menghubungkan komponen tampilan dengan ID yang ada di XML
        val welcomeTextView = findViewById<TextView>(R.id.textViewWelcome)
        val nameTextView = findViewById<TextView>(R.id.textViewName)
        val chooseUserButton = findViewById<Button>(R.id.buttonChooseUser)

        // Menerima nama pengguna yang dikirimkan dari FirstScreen
        val name = intent.getStringExtra("NAME")
        welcomeTextView.text = "Welcome"
        nameTextView.text = name

        // Tombol untuk memilih pengguna dan melanjutkan ke ThirdScreen
        chooseUserButton.setOnClickListener {
            val intent = Intent(this, ThirdScreen::class.java)
            startActivityForResult(intent, 100)
        }
    }

    // Mengambil hasil yang dikirim dari ThirdScreen (nama pengguna yang dipilih)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            // Mendapatkan nama pengguna yang dipilih dari data yang dikirimkan
            val selectedUserName = data?.getStringExtra("SELECTED_USER_NAME")
            // Menampilkan nama pengguna yang dipilih pada TextView
            findViewById<TextView>(R.id.textViewSelectedUser).text = selectedUserName
        }
    }
}
