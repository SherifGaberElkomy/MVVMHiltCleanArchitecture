package com.example.mvvmhiltcleanarchitecture.di

import com.example.mvvmhiltcleanarchitecture.data.remote.RetrofitService
import com.example.mvvmhiltcleanarchitecture.features.album.data.repository.AlbumRepositoryImpl
import com.example.mvvmhiltcleanarchitecture.features.album.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideAlbumRepository(
        retrofitService: RetrofitService
    ): AlbumRepository {
        return AlbumRepositoryImpl(retrofitService)
    }

}