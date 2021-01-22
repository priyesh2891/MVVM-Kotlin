package io.cloudium.fyme.data.remote.services

import io.cloudium.fyme.data.entities.ContactList
import io.cloudium.fyme.data.entities.Contacts
import io.cloudium.fyme.data.entities.Test
import io.cloudium.fyme.data.entities.TestResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContactService {
    @GET("character")
    suspend fun getAllCharacters() : Response<ContactList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Contacts>

    @POST("/api/users")
    suspend fun postLogin(@Body name: Test): Response<TestResult>
}