package org.sopt.androidseminar.api

import org.sopt.androidseminar.home.dto.RequestLoginData
import org.sopt.androidseminar.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptApi {
    @POST("/login/signin")
    fun postLogin(
        @Body body : RequestLoginData
    ) : Call<ResponseLoginData>
}