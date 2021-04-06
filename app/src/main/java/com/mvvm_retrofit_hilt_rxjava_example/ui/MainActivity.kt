package com.mvvm_retrofit_hilt_rxjava_example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm_retrofit_hilt_rxjava_example.R
import com.mvvm_retrofit_hilt_rxjava_example.Status
import com.mvvm_retrofit_hilt_rxjava_example.data.model.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUi()
        setupApiCall()
    }

    private fun setupApiCall() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { userData -> renderList(userData) }
                    recyclerView.visibility = View.VISIBLE
                }

                Status.LOADING -> {
                    recyclerView.visibility
                }
            }
        })
        mainViewModel.fetchUsers()
    }

    private fun setupUi() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(this)
        renderList(listOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun renderList(users: List<User>) {
        adapter.apply {
            adapter.addData(users)
            adapter.notifyDataSetChanged()
        }
    }
}