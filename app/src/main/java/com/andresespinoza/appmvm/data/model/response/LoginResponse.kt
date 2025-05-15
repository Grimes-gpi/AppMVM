package com.andresespinoza.appmvm.data.model.response

import android.os.Message
import com.andresespinoza.appmvm.data.model.UserModel
import com.google.gson.annotations.SerializedName

data class LoginResponse(
 @SerializedName("message") val message: String?,
 @SerializedName("data") val data: UserModel?,
 @SerializedName("status") val status: String?,

 )
