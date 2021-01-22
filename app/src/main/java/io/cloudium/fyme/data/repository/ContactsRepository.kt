package io.cloudium.fyme.data.repository
import androidx.lifecycle.LiveData
import io.cloudium.fyme.data.entities.Test
import io.cloudium.fyme.data.local.Dao.ContactDao
import io.cloudium.fyme.data.remote.ContactRemoteDataSource
import io.cloudium.fyme.utils.performGetOperation
import io.cloudium.fyme.utils.performPost
import javax.inject.Inject

class ContactsRepository @Inject constructor(
        private val remoteDataSource: ContactRemoteDataSource,
        private val localDataSource: ContactDao
) {

    fun getContact(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getContact(id) },
        networkCall = { remoteDataSource.getContactByIdFromApi(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getContacts() = performGetOperation(
        databaseQuery = { localDataSource.getAllContacts() },
        networkCall = { remoteDataSource.getContactsFromApi() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )

    fun postApi(name: Test) = performPost(
        networkCall = { remoteDataSource.postApi(name) }
    )
}