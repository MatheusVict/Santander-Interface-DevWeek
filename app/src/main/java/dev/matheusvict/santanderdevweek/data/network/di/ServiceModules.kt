package dev.matheusvict.santanderdevweek.data.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.matheusvict.santanderdevweek.data.network.service.AccountService
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class ServiceModules {
    @Provides
    fun provideAuthService(retrofit: Retrofit) = retrofit.create<AccountService>()
}