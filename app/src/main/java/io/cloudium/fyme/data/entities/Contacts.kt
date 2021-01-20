package io.cloudium.fyme.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contacts(
    @PrimaryKey
    val id : Int,
    val created: String,
    val name: String,
    val status: String,
    val gender: String,
)
