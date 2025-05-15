package com.andresespinoza.appmvm.data.network

import com.andresespinoza.appmvm.core.RetrofitHelper
import com.andresespinoza.appmvm.data.model.request.LoginRequest
import com.andresespinoza.appmvm.data.model.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthApiService {
    private val retrofitAuth = RetrofitHelper.getRetrofitAuth()

    suspend fun login(loginRequest: LoginRequest):LoginResponse{
        return withContext(Dispatchers.IO){
            val response = retrofitAuth.create(AuthApiClient::class.java).login(loginRequest)
            (response.body() ?: LoginResponse("Problemas con el servidor",null,"error")) as LoginResponse
        }
    }

}
