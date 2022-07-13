package com.kimmichel.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editUser: EditText
    private lateinit var editPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUser = findViewById(R.id.edit_user)
        editPass = findViewById(R.id.edit_pass)

        val btnRegister: Button = findViewById(R.id.btn_regis)
        btnRegister.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }

        val btnResetPassword: TextView = findViewById(R.id.btn_res)
        btnResetPassword.setOnClickListener {
            val i = Intent(this, ResetPassActivity::class.java)
            startActivity(i)
        }

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            if (!fieldsValidate()) {
                Toast.makeText(this, R.string.field_message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

    }

    private fun fieldsValidate(): Boolean {
        return (editUser.text.toString().isNotEmpty()
                && editPass.text.toString().isNotEmpty())
    }
}