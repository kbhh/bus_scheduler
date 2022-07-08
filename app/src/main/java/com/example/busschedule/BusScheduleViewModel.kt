package com.example.busschedule

import androidx.lifecycle.ViewModel
import com.example.busschedule.data.ScheduleDao
import com.example.busschedule.data.Schedule
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val scheduleDao: ScheduleDao):ViewModel() {

   fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()
   fun scheduleForStopName(stopName: String): Flow<List<Schedule>> = scheduleDao.getByStopName(stopName)

}