package com.ntheng.gunpla_planning_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ntheng.gunpla_planning_app.util.STATUS

@Entity
data class Project (
    @PrimaryKey(autoGenerate = true) val project_id: Int,

    val project_name: String,
    val status: STATUS
)