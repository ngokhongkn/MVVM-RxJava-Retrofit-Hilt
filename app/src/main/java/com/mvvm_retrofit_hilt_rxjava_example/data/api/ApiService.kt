package com.mvvm_retrofit_hilt_rxjava_example.data.api

import com.mvvm_retrofit_hilt_rxjava_example.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Single<List<User>>
}