package dev.matheusvict.santanderdevweek.data.network.service

import dev.matheusvict.santanderdevweek.data.model.Response
import retrofit2.http.GET

interface AccountService {
    @GET("users/2")
    suspend fun getAccount(): Response
}