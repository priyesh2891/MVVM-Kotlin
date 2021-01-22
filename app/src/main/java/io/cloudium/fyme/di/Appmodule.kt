package io.cloudium.fyme.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.cloudium.fyme.data.local.AppDatabase
import io.cloudium.fyme.data.local.Dao.ContactDao
import io.cloudium.fyme.data.remote.ContactRemoteDataSource
import io.cloudium.fyme.data.remote.services.ContactService
import io.cloudium.fyme.data.repository.ContactsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideContactService(retrofit: Retrofit): ContactService = retrofit.create(ContactService::class.java)

    @Singleton
    @Provides
    fun provideContactRemoteDataSource(contactService: ContactService) = ContactRemoteDataSource(contactService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideContactDao(db: AppDatabase) = db.contactDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: ContactRemoteDataSource,
                          localDataSource: ContactDao
    ) =
        ContactsRepository(remoteDataSource, localDataSource)
}