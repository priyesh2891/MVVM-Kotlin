package io.cloudium.fyme.data.remote

import io.cloudium.fyme.data.entities.Test
import io.cloudium.fyme.data.remote.services.ContactService
import javax.inject.Inject

class ContactRemoteDataSource @Inject constructor(
    private val contactService: ContactService
): BaseDataSource() {

    suspend fun getContactsFromApi() = getResult { contactService.getAllCharacters() }
    suspend fun getContactByIdFromApi(id: Int) = getResult { contactService.getCharacter(id) }

    suspend fun postApi(name:Test) = getResult { contactService.postLogin(name) }
}
