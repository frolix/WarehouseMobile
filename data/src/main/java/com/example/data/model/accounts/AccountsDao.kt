package com.example.data.model.accounts

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface AccountsDao {
//    @Query("SELECT id, password FROM accounts WHERE email = :email")
//    suspend fun findByEmail(email: String): AccountSignInTuple?
//
//    @Update(entity = AccountsEntity::class)
//    suspend fun updateUsername(account: AccountUpdateUsernameTuple)
//
//    @Insert(entity = AccountsEntity::class)
//    suspend fun createAccount(accountDbEntity: AccountDbEntity)

    @Query("SELECT * FROM accounts WHERE id = :accountId")
    fun getById(accountId: Long): Flow<AccountsEntity?>

//    @Transaction
//    @Query("SELECT * FROM accounts WHERE accounts.id = :accountId")
//    fun getAccountAndEditedBoxes(accountId: Long): AccountAndEditedBoxesTuple
//
//    @Transaction
//    @Query("SELECT * FROM accounts")
//    fun getAllData(): Flow<List<AccountAndAllSettingsTuple>>
}
