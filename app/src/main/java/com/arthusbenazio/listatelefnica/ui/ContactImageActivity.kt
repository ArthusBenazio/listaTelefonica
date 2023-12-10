package com.arthusbenazio.listatelefnica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arthusbenazio.listatelefnica.R
import com.arthusbenazio.listatelefnica.databinding.ActivityContactImageBinding

class ContactImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactImageBinding
    private lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = intent

        binding.imageBoy.setOnClickListener { sendID(R.drawable.boy) }
        binding.imageBoy1.setOnClickListener { sendID(R.drawable.boy1) }
        binding.imageBoy2.setOnClickListener { sendID(R.drawable.boy2) }
        binding.imageGirl.setOnClickListener { sendID(R.drawable.girl) }
        binding.imageGirl1.setOnClickListener { sendID(R.drawable.girl1) }
        binding.imageGirl2.setOnClickListener { sendID(R.drawable.girl2) }
        binding.buttonRemoveImage.setOnClickListener { sendID(R.drawable.contacts_icon) }
    }

    private fun sendID(id: Int) {
        i.putExtra("id", id)
        setResult(1, i)
        finish()
    }
}