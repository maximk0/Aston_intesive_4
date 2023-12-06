package com.example.fragmentsapi.second_task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsapi.databinding.ItemUserBinding
import com.example.fragmentsapi.second_task.data.User

class UsersRecyclerViewAdapter(
    private val onClickUser: (userId: Int) -> Unit,
) : RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>() {

    private var users: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = users[position]
        with(holder.binding) {
            name.text = item.name
            lastName.text = item.lastName
            phoneNumber.text = item.phoneNumber

            root.setOnClickListener {
                onClickUser(item.id)
            }
        }
    }

    override fun getItemCount(): Int = users.size

    fun setData(countryList: List<User>) {
        users = countryList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

}
