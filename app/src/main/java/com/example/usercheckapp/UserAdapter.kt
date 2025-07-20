package com.example.usercheckapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usercheckapp.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users = mutableListOf<User>()  // Menggunakan mutable list agar bisa menambah data

    // Method untuk menambahkan item baru
    fun addItems(newUsers: List<User>) {
        users.addAll(newUsers)
        notifyItemRangeInserted(users.size - newUsers.size, newUsers.size)
    }

    fun submitList(users: List<User>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount() = users.size

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.textViewName.text = "${user.first_name} ${user.last_name}"
            binding.textViewEmail.text = user.email
            Picasso.get().load(user.avatar).into(binding.imageViewAvatar)

            itemView.setOnClickListener {
                onItemClickListener?.invoke(user)
            }
        }
    }

    private var onItemClickListener: ((User) -> Unit)? = null

    fun setOnItemClickListener(listener: (User) -> Unit) {
        onItemClickListener = listener
    }
}
