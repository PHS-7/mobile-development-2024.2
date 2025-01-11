package com.example.crudapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase(){

    abstract fun userDao(): UserDAO


    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null


        fun getDataBase(context: Context): AppDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "user_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}