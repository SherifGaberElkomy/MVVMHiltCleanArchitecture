package com.example.mvvmhiltcleanarchitecture.features.album.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mvvmhiltcleanarchitecture.R
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class AlbumsFragment : Fragment() {
    private val viewModel: AlbumViewModel by viewModels()
    private var progressLoading: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_albums, container, false)
        loadControl(view!!)
        viewModel.getSuccessResult().observe(viewLifecycleOwner) {
            Toast.makeText(requireActivity(), it[0].title, Toast.LENGTH_LONG).show()
        }
        viewModel.getErrorResult().observe(viewLifecycleOwner) {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        }
        viewModel.checkLoadingData().observe(viewLifecycleOwner){
            progressLoading?.visibility = View.GONE
        }
        viewModel.loadAlbums()

        return view
    }

    private fun loadControl(view: View) {
        progressLoading = view.findViewById(R.id.loading_pb)
    }

    companion object {
        val FRAGMENT_NAME = AlbumsFragment::class.java.name
        @JvmStatic
        fun newInstance() =
            AlbumsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}