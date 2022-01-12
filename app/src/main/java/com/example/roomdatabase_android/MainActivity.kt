package com.example.roomdatabase_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity()
{
    companion object
    {
        const val TAG = "MainActivity"
    }

    private lateinit var database : ContactDatabase
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = ContactDatabase.getDatabase(this)
        GlobalScope.launch {
            database.contactDao()
                .insertContact(Contact(0 , "Raaj Kanchan" , "7718881920" , Date() , 1))
        }
    }

    fun getData(view : android.view.View)
    {
        database.contactDao().getContacts().observe(this , Observer {
            Log.d(TAG , "getData :: SQLiteData : ${it.toString()}")
        })
    }
}