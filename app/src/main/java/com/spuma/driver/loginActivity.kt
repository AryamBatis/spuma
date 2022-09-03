package com.spuma.driver

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.spumadriver.R
import kotlinx.android.synthetic.main.activity_login.*


class loginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("HardwareIds")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        sharedPreferences = getSharedPreferences("phone_number",Context .MODE_PRIVATE)
        val sendButton = findViewById<Button>(R.id.send_button)

        sendButton.setOnClickListener {
            val number:Int = number_editText.text.toString().toInt()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("NUMBER", number)
            editor.apply()
            val intent = Intent(this, verifyActivity::class.java)
            startActivity(intent)
        }

    }

}