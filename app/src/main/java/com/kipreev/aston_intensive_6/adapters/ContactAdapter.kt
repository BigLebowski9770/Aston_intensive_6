package com.kipreev.aston_intensive_6.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kipreev.aston_intensive_6.R
import com.kipreev.aston_intensive_6.databinding.ContactItemBinding
import com.kipreev.aston_intensive_6.model.Contact


class ContactAdapter(
    val listener: Listener
) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    val contactList = ArrayList<Contact>()

    class ContactHolder(item: View) : RecyclerView.ViewHolder(item) {

        val binding = ContactItemBinding.bind(item)
        fun bind(contact: Contact, listener: Listener) = with(binding) {
            image.load(contact.picLink)
            firstName.text = contact.firstName
            lastName.text = contact.lastName
            phoneNumber.text = contact.phoneNumber
            id.text = contact.id.toString()

            itemView.setOnClickListener {
                listener.onClick(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(contactList[position], listener)

    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun addContact(contact: Contact) {
        contactList.add(contact)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(contact: Contact)
    }
}