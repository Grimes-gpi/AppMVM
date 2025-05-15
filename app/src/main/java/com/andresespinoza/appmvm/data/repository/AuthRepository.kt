package com.andresespinoza.appmvm.data.repository

import com.andresespinoza.appmvm.data.model.UserProvider
import com.andresespinoza.appmvm.data.model.request.LoginRequest
import com.andresespinoza.appmvm.data.model.response.LoginResponse
import com.andresespinoza.appmvm.data.network.AuthApiService

class AuthRepository {
    private val authApiService = AuthApiService()
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        val response = authApiService.login(loginRequest)
        if (response.status == "sucess"){
            UserProvider.user = response.data

        }
        return response
    }
}