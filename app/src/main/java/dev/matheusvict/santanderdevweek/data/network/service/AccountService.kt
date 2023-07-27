package dev.matheusvict.santanderdevweek.data.network.service

import dev.matheusvict.santanderdevweek.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountService {
    @GET("users/{id}")
    suspend fun getAccount(@Path("id") id: Long): Response
}