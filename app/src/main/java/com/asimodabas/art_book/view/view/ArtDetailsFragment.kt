package com.asimodabas.art_book.view.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asimodabas.art_book.R
import com.asimodabas.art_book.databinding.FragmentArtDetailBinding

class ArtDetailsFragment : Fragment(R.layout.fragment_art_detail) {

    private var fragmentBinding : FragmentArtDetailBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtDetailBinding.bind(view)
        fragmentBinding = binding

        binding.artImageView.setOnClickListener {
            findNavController().navigate(com.asimodabas.art_book.view.ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageAPIFragment())
        }

        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()

    }
}