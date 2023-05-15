package com.example.mvvmhiltcleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmhiltcleanarchitecture.data.remote.RetrofitService
import com.example.mvvmhiltcleanarchitecture.features.album.presentation.AlbumsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.gallery_container,
                AlbumsFragment.newInstance(),
                AlbumsFragment.FRAGMENT_NAME
            ).commitAllowingStateLoss()
    }
}