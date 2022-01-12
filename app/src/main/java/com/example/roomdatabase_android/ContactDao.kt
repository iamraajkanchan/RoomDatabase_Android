package com.example.roomdatabase_android

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact : Contact)

    @Update
    suspend fun updateContact(contact : Contact)

    @Delete
    suspend fun deleteContact(contact : Contact)

    @Query("SELECT * from contact")
    fun getContacts() : LiveData<List<Contact>>

}