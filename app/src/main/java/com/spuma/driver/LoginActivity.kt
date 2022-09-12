package com.spuma.driver.presentation.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.spumadriver.R
import com.spuma.driver.*
import com.spuma.driver.ApiClient
import com.spuma.driver.ApiInterface
import com.spuma.driver.LocaleHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class loginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var preferences: SharedPreferences
    @SuppressLint("HardwareIds")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val number_editText = findViewById<EditText>(R.id.number_editText)


        sharedPreferences = getSharedPreferences("phone_number",Context .MODE_PRIVATE)

        val sendButton = findViewById<Button>(R.id.send_button)
        val retrofit = ApiClient.buildService(ApiInterface::class.java)
        val uid: String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val lang = LocaleHelper().getLanguage(this)
        preferences = getSharedPreferences("phone_number", Context.MODE_PRIVATE)
        val number2 = preferences.getInt("NUMBER",0)

        val device = DeviceModel(
            uid = uid,
            type = "android"
        )

        val driver = DriverModel(
            mobile = "966$number2"
            ,lang = lang
            , country_code = "SA"
            ,device = device
        )

       sendButton.isEnabled = false
        number_editText.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
               sendButton.isEnabled = s.toString().trim{ it <= ' ' }.isNotEmpty()
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
            }
            override fun afterTextChanged(s: Editable) {

            }
        })
      sendButton.setOnClickListener {
            val number:Int = number_editText.text.toString().toInt()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("NUMBER", number)
            editor.apply()
            val intent = Intent(this, verifyActivity::class.java)
            startActivity(intent)

          retrofit.driverLogin(driver).enqueue(object: Callback<DriverModel> {
                override fun onResponse(
                    call: Call<DriverModel>,
                    response: Response<DriverModel>
                ) {

                   // Toast.makeText(this@loginActivity,response.message().toString(), Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<DriverModel>, t: Throwable) {
                    Toast.makeText(this@loginActivity,t.toString(), Toast.LENGTH_LONG).show()
                }

            }
            )
        }

    }

}