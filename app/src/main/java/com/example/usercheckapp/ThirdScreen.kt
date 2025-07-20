package com.example.usercheckapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usercheckapp.databinding.ThirdScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdScreen : AppCompatActivity() {

    private lateinit var binding: ThirdScreenBinding
    private val userAdapter = UserAdapter()
    private var currentPage = 1 // Menyimpan halaman saat ini
    private var isLoading = false  // Untuk mencegah permintaan ganda saat masih memuat data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan ViewBinding untuk menghubungkan layout
        binding = ThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menyiapkan RecyclerView dengan Adapter dan LayoutManager
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewUsers.adapter = userAdapter

        // Memuat data pertama kali
        fetchUsers(currentPage)

        // Menambahkan listener untuk Swipe-to-Refresh
        binding.swipeRefreshLayout.setOnRefreshListener {
            currentPage = 1 // Reset halaman ke 1
            fetchUsers(currentPage) // Refresh data ketika swipe dilakukan
        }

        // Menambahkan listener untuk memuat lebih banyak data saat mencapai akhir
        binding.recyclerViewUsers.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Mengecek jika sudah mencapai bawah dari daftar
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    currentPage++ // Menambah halaman jika mencapai bawah
                    fetchUsers(currentPage) // Memuat halaman berikutnya
                }
            }
        })

        // Menambahkan listener untuk item yang diklik
        userAdapter.setOnItemClickListener { user ->
            // Mengirim data nama pengguna yang dipilih kembali ke SecondScreen
            val resultIntent = Intent()
            resultIntent.putExtra("SELECTED_USER_NAME", "${user.first_name} ${user.last_name}")
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Kembali ke SecondScreen setelah memilih user
        }
    }

    private fun fetchUsers(page: Int) {
        isLoading = true

        RetrofitClient.apiService.getUsers(page, 10)
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    if (response.isSuccessful) {
                        val userResponse = response.body()
                        if (userResponse != null) {
                            if (page == 1) {
                                userAdapter.submitList(userResponse.data)
                            } else {
                                userAdapter.addItems(userResponse.data)
                            }
                        }
                    }
                    binding.swipeRefreshLayout.isRefreshing = false
                    isLoading = false
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Toast.makeText(this@ThirdScreen, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    binding.swipeRefreshLayout.isRefreshing = false
                    isLoading = false
                }
            })
    }
}
