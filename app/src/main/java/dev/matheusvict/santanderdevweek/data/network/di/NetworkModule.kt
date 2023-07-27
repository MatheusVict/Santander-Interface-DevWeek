package dev.matheusvict.santanderdevweek.data.network.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val url = "https://web-production-8792.up.railway.app"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl(url)

    @Provides
    @Singleton
    fun provideRetrofit(
        builder: Retrofit.Builder,
    ): Retrofit = builder
        .client(OkHttpClient.Builder().build())
        .build()
}