package com.ntheng.gunpla_planning_app.data

import androidx.room.*

interface EquipmentDao {
    @Query("SELECT * FROM equipment")
    fun getAll(): List<Equipment>

    @Query("SELECT * FROM equipment WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Project
}