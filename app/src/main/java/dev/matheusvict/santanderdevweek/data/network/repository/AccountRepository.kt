package dev.matheusvict.santanderdevweek.data.network.repository

import dev.matheusvict.santanderdevweek.data.network.service.AccountService
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountService: AccountService
) {
    suspend fun getAccount() = accountService.getAccount(2)
}