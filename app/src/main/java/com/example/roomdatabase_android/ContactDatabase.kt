package com.example.roomdatabase_android

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Contact::class] , version = 2)
@TypeConverters(Converter::class)
abstract class ContactDatabase : RoomDatabase()
{
    abstract fun contactDao() : ContactDao

    companion object
    {
        val migration2_1 = object : Migration(
            1 , 2
        )
        {
            override fun migrate(database : SupportSQLiteDatabase)
            {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        /* Informs the entire thread that the value of a variable (e.g. INSTANCE) is updated */

        @Volatile
        private var INSTANCE : ContactDatabase? = null
        fun getDatabase(context : Context) : ContactDatabase
        {
            if (INSTANCE == null)
            {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context , ContactDatabase::class.java , "ContactDB")
                            .addMigrations(
                                migration2_1
                            ).build()
                }
            }

            /* returning a non-nullable INSTANCE */
            return INSTANCE !!
        }
    }
}