package com.example.mvvmhiltcleanarchitecture.features.album.domain.repository

import com.example.mvvmhiltcleanarchitecture.features.album.domain.model.Album
import io.reactivex.Single

interface AlbumRepository {
    fun getAlbums(): Single<List<Album>>
}