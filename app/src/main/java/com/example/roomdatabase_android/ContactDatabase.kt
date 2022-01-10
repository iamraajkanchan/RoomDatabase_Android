package com.example.roomdatabase_android

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Contact::class] , version = 1)
abstract class ContactDatabase : RoomDatabase()
{
    abstract fun contactDao() : ContactDao

    companion object
    {
        private var INSTANCE : ContactDatabase? = null
        fun getDatabase(context : Context) : ContactDatabase
        {
            if (INSTANCE == null)
            {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context , ContactDatabase::class.java , "ContactDB")
                            .build()
                }
            }
            return INSTANCE !!
        }
    }
}