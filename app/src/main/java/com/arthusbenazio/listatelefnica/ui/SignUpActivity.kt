package com.arthusbenazio.listatelefnica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arthusbenazio.listatelefnica.R
import com.arthusbenazio.listatelefnica.database.DBHelper
import com.arthusbenazio.listatelefnica.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelper(this)

        binding.buttonSignup.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val confirmPassword = binding.editConfirmPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    val res = db.insertUser(username, password)
                    if (res > 0) {
                        Toast.makeText(applicationContext, getString(R.string.signup_ok), Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.signup_error),
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.editUsername.setText("")
                        binding.editPassword.setText("")
                        binding.editConfirmPassword.setText("")
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.passwords_don_t_match),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.please_insert_all_required_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}