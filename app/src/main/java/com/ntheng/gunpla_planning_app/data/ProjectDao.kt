package com.ntheng.gunpla_planning_app.data

import androidx.room.*

@Dao
interface ProjectDao {
    @Query("SELECT * FROM project")
    fun getAll(): List<Project>

    @Query("SELECT * FROM project WHERE project_name LIKE :name LIMIT 1")
    fun findByName(name: String): Project

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertProject(project: Project)

    @Update
    fun updateProject(project: Project)

    @Delete
    fun deleteProject(project: Project)
}