package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Schedule::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
   companion object {
       const val DATABASE_NAME = "app.db"
       @Volatile
         private var instance: AppDatabase? = null
       fun getDatabase(context: Context): AppDatabase {
           return instance ?: synchronized(this) {
               val newInstance = Room.databaseBuilder(context,
                     AppDatabase::class.java,
                     DATABASE_NAME
               ).createFromAsset("database/bus_schedule.db").build()
               instance = newInstance
               instance!!
           }
       }
   }
}