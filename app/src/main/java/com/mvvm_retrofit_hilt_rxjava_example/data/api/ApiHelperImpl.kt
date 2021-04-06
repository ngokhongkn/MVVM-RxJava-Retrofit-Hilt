package com.mvvm_retrofit_hilt_rxjava_example.data.api

import com.mvvm_retrofit_hilt_rxjava_example.data.model.User
import io.reactivex.Single
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService):
    ApiHelper {

    override fun getUsers(): Single<List<User>> {
        return apiService.getUsers()
    }

}