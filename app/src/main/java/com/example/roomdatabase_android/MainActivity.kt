package com.example.roomdatabase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()
{
    private lateinit var database : ContactDatabase
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = ContactDatabase.getDatabase(this)
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0 , "Raaj Kanchan" , "7718881920"))
        }
    }
}