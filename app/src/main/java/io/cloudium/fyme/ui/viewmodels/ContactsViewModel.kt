package io.cloudium.fyme.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.cloudium.fyme.data.repository.ContactsRepository

class ContactsViewModel @ViewModelInject constructor(
    private val repository: ContactsRepository
) : ViewModel() {

    val contacts = repository.getContacts()
}