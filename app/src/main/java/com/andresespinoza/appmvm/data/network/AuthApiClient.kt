package com.andresespinoza.appmvm.data.network

import com.andresespinoza.appmvm.data.model.request.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiClient {
    @POST("sign_in")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginRequest>
}