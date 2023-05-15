package com.example.mvvmhiltcleanarchitecture.features.album.data.repository

import com.example.mvvmhiltcleanarchitecture.data.remote.RetrofitService
import com.example.mvvmhiltcleanarchitecture.features.album.domain.model.Album
import com.example.mvvmhiltcleanarchitecture.features.album.domain.repository.AlbumRepository
import io.reactivex.Single

class AlbumRepositoryImpl(private val retrofitService: RetrofitService) : AlbumRepository {

    override fun getAlbums(): Single<List<Album>> {
        return retrofitService.getAlbums()
    }
}