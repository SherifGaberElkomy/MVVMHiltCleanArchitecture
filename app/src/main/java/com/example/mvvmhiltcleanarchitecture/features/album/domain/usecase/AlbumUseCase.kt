package com.example.mvvmhiltcleanarchitecture.features.album.domain.usecase

import com.example.mvvmhiltcleanarchitecture.domaiin.base.SingleUseCase
import com.example.mvvmhiltcleanarchitecture.features.album.domain.model.Album
import com.example.mvvmhiltcleanarchitecture.features.album.domain.repository.AlbumRepository
import io.reactivex.Single
import javax.inject.Inject

class AlbumUseCase @Inject constructor(private val repository: AlbumRepository):
    SingleUseCase<List<Album>>() {
    override fun buildUseCaseSingle(): Single<List<Album>> {
        return repository.getAlbums()
    }

}