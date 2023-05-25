package com.kipreev.aston_intensive_6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kipreev.aston_intensive_6.R
import com.kipreev.aston_intensive_6.adapters.ContactAdapter
import com.kipreev.aston_intensive_6.databinding.ListFragmentBinding
import com.kipreev.aston_intensive_6.getTag
import com.kipreev.aston_intensive_6.model.Contact


class ListFragment : Fragment(R.layout.list_fragment), ContactAdapter.Listener {

    lateinit var binding: ListFragmentBinding
    private val adapter = ContactAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(context, 2)
            rcView.adapter = adapter

            for (i in 1 until 101) {
                val contact = Contact(
                    "Salvador  $i",
                    "Dali",
                    "79230354787",
                    "https://loremflickr.com/300/300/person?random=$i",
                    i
                )
                adapter.addContact(contact)
            }
        }
    }

    override fun onClick(contact: Contact) {
        val infoFragment = InfoFragment()
        val bundle = Bundle()

        bundle.putString(FIRST_NAME, contact.firstName)
        bundle.putString(LAST_NAME, contact.lastName)
        bundle.putString(PHONE_NUMBER, contact.phoneNumber)
        bundle.putString(PIC_LINK, contact.picLink)

        infoFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, infoFragment, InfoFragment::class.getTag())
            .addToBackStack(InfoFragment::class.getTag())
            .commit()
    }

    companion object {
        private const val FIRST_NAME = "first name"
        private const val LAST_NAME = "last name"
        private const val PHONE_NUMBER = "phone number"
        private const val PIC_LINK = "pic link"
    }
}