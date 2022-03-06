package com.asimodabas.art_book.view.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asimodabas.art_book.R
import com.asimodabas.art_book.databinding.FragmentArtsBinding

class ArtFragment : Fragment(R.layout.fragment_arts) {

    private var fragmentBinding: FragmentArtsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtsBinding.bind(view)
        fragmentBinding = binding

        binding.fab.setOnClickListener {
            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }
}