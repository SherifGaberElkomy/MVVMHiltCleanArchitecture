package com.example.mvvmhiltcleanarchitecture.data.remote

import com.example.mvvmhiltcleanarchitecture.features.album.domain.model.Album
import com.example.mvvmhiltcleanarchitecture.features.photo.domain.model.Photo
import dagger.Provides
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {
    @GET("albums/")
    fun getAlbums(): Single<List<Album>>

    @GET("albums/{id}/photos")
    fun getPhotos(@Path("id") id: Long): Single<List<Photo>>

    @GET("photos/{id}")
    fun getPhotoDetail(@Path("id") id: Long): Single<Photo>
}