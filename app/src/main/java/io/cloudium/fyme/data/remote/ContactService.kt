package io.cloudium.fyme.data.remote

import io.cloudium.fyme.data.entities.ContactList
import io.cloudium.fyme.data.entities.Contacts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ContactService {
    @GET("character")
    suspend fun getAllCharacters() : Response<ContactList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Contacts>
}