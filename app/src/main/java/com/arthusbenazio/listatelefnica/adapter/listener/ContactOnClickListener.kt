package com.arthusbenazio.listatelefnica.adapter.listener

import com.arthusbenazio.listatelefnica.model.ContactModel

class ContactOnClickListener(val clickListener: (contact: ContactModel) -> Unit) {
    fun onClick(contact: ContactModel) = clickListener
}