package com.ntheng.gunpla_planning_app.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(entity = Project::class, parentColumns = ["project_id"],
            childColumns = ["project_id"])
    ]
)
data class Equipment(
    @PrimaryKey(autoGenerate = true) var equipment_id: Long,
    val project_id: Int,

    val name: String,
    val brand: String,
    val owned: Boolean,
    val colour: String
)
