package com.mvvm_retrofit_hilt_rxjava_example.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("id")
    val id: String? = "",

    @field:SerializedName("avatar")
    val avatar: String? = "",

    @field:SerializedName("email")
    val email: String? = ""
)