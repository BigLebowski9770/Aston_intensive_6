package com.kipreev.aston_intensive_6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import coil.load
import com.kipreev.aston_intensive_6.R


class InfoFragment : Fragment(R.layout.info_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = this.arguments

        val link = args?.getString("pic link")

        view.findViewById<ImageView>(R.id.picture_detail).load(link)

        view.findViewById<EditText>(R.id.first_name)
            .setText(args?.getString("first name").toString())

        view.findViewById<EditText>(R.id.last_name)
            .setText(args?.getString("last name").toString())

        view.findViewById<EditText>(R.id.phone_number)
            .setText(args?.getString("phone number").toString())

    }

    companion object {

        fun getInstance(value: String): InfoFragment {
            return InfoFragment().apply {
                arguments = bundleOf("KEY" to value)
            }
        }
    }
}