package io.cloudium.fyme.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.cloudium.fyme.data.entities.Test
import io.cloudium.fyme.data.repository.ContactsRepository

class ContactsViewModel @ViewModelInject constructor(
    repository: ContactsRepository
) : ViewModel() {

    val contacts = repository.getContacts()
    var test = Test("name","job")
    val createContact = repository.postApi(test)
}