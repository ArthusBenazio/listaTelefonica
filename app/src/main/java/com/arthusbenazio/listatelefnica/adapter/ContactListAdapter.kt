package com.arthusbenazio.listatelefnica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arthusbenazio.listatelefnica.R
import com.arthusbenazio.listatelefnica.adapter.listener.ContactOnClickListener
import com.arthusbenazio.listatelefnica.adapter.viewholder.ContactViewHolder
import com.arthusbenazio.listatelefnica.model.ContactModel

class ContactListAdapter(
    private val contactList: List<ContactModel>,
    private val contactOnClickListener: ContactOnClickListener
) : RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.textName.text = contact.name
        if (contact.imageId > 0) {
            holder.image.setImageResource(contact.imageId)
        } else {
            holder.image.setImageResource(R.drawable.contacts_icon)
        }
        holder.itemView.setOnClickListener {
            contactOnClickListener.clickListener(contact)
        }
    }
}