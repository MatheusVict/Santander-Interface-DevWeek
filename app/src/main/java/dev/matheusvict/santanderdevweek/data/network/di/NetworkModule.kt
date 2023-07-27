package dev.matheusvict.santanderdevweek.data.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val url = "https://web-production-8792.up.railway.app"

    @Provides
    @Singleton
    fun provideRetrofit(
        builder: Retrofit.Builder,
    ): Retrofit = builder
        .client(OkHttpClient.Builder().build())
        .build()
}