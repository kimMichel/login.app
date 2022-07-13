package com.kimmichel.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var editUser: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPass: EditText
    private lateinit var editConfPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editUser = findViewById(R.id.regis_edit_user)
        editEmail = findViewById(R.id.regis_edit_email)
        editPass = findViewById(R.id.regis_edit_pass)
        editConfPass = findViewById(R.id.regis_edit_conf_pass)

        val btnRegister: Button = findViewById(R.id.regis_btn_regis)
        btnRegister.setOnClickListener {
            if (!fieldsValidate()) {
                Toast.makeText(this, R.string.field_message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!matchPasswordValidate()) {
                Toast.makeText(this, R.string.password_confirm_message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    private fun fieldsValidate(): Boolean {
        return (editUser.text.toString().isNotEmpty()
                &&editEmail.text.toString().isNotEmpty()
                &&editPass.text.toString().isNotEmpty()
                &&editConfPass.text.toString().isNotEmpty())
    }

    private fun matchPasswordValidate(): Boolean {
        return (editPass.text.toString() == editConfPass.text.toString())
    }
}