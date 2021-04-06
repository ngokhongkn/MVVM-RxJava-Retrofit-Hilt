package com.mvvm_retrofit_hilt_rxjava_example.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvm_retrofit_hilt_rxjava_example.R
import com.mvvm_retrofit_hilt_rxjava_example.data.model.User
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.item_layout.view.*
import javax.inject.Inject

class MainAdapter @Inject constructor(
    @ActivityContext val context: Context
): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private var users: ArrayList<User> = ArrayList()

    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(user: User, context: Context) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        return holder.bind(users[position], context)
    }

    fun addData(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}