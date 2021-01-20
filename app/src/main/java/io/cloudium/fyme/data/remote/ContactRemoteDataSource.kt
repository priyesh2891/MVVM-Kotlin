package io.cloudium.fyme.data.remote

import javax.inject.Inject

class ContactRemoteDataSource @Inject constructor(
    private val contactService: ContactService
): BaseDataSource() {

    suspend fun getContactsFromApi() = getResult { contactService.getAllCharacters() }
    suspend fun getContactByIdFromApi(id: Int) = getResult { contactService.getCharacter(id) }
}
