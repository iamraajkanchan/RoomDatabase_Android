package com.example.roomdatabase_android

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact : Contact)

    @Update
    fun updateContact(contact : Contact)

    @Delete
    fun deleteContact(contact : Contact)

    @Query("SELECT * from contact")
    fun getContacts() : LiveData<List<Contact>>

}