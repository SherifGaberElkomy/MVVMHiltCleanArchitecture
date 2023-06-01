package com.example.mvvmhiltcleanarchitecture.features.album.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmhiltcleanarchitecture.features.album.domain.model.Album
import com.example.mvvmhiltcleanarchitecture.features.album.domain.usecase.AlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val albumUseCase: AlbumUseCase) : ViewModel() {
    private val albumSuccessLiveDataObserver: MutableLiveData<List<Album>> = MutableLiveData()
    private val albumFailurLiveDataObserver: MutableLiveData<String> = MutableLiveData()
    private val isLoadingData: MutableLiveData<Boolean> = MutableLiveData()

    fun loadAlbums() {
        albumUseCase.execute(
            onSuccess = { result ->
                albumSuccessLiveDataObserver.value = result
            },
            onError = { error ->
                albumFailurLiveDataObserver.value = error.message!!
            },
            onFinished = {
                isLoadingData.value = true
            }
        )
    }

    fun getSuccessResult(): MutableLiveData<List<Album>>{
        return albumSuccessLiveDataObserver
    }

    fun getErrorResult(): MutableLiveData<String>{
        return albumFailurLiveDataObserver
    }

    fun checkLoadingData(): MutableLiveData<Boolean>{
        return isLoadingData
    }
}