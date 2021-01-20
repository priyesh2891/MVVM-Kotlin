package io.cloudium.fyme.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.cloudium.fyme.data.entities.Contacts

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    fun getAllContacts() : LiveData<List<Contacts>>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContact(id: Int): LiveData<Contacts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contacts: List<Contacts>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: Contacts)


}