package com.mvvm_retrofit_hilt_rxjava_example.data.repository

import com.mvvm_retrofit_hilt_rxjava_example.data.model.User
import com.mvvm_retrofit_hilt_rxjava_example.data.api.ApiHelper
import io.reactivex.Single
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }
}