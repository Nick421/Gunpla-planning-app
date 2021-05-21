package com.ntheng.gunpla_planning_app.data

import androidx.room.Database
import androidx.room.RoomDatabase

class AppDatabase {
    @Database(entities = arrayOf(Project::class, Equipment::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun projectDao(): ProjectDao
        abstract fun equipmentDao(): EquipmentDao
    }
}