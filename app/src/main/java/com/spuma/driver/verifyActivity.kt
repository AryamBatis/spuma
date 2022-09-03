package com.spuma.driver

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.spumadriver.R
import com.spuma.driver.services.ApiInterface
import com.spuma.driver.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_verify.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class verifyActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    @SuppressLint("SetTextI18n", "HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        val uid: String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val lang = LocaleHelper().getLanguage(this)
        preferences = getSharedPreferences("phone_number", Context.MODE_PRIVATE)
        val number = preferences.getInt("NUMBER",0)
        textViewNumber.text = "+966$number"

      val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)
        val obj = RequestModel(number.toString(),lang,"SA",uid,"android")

        retrofit.sendReq().enqueue(
            object: Callback<ResponseModel> {
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                    Toast.makeText(this@verifyActivity,response.message().toString(),Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    Toast.makeText(this@verifyActivity,t.toString(),Toast.LENGTH_LONG).show()
                }

            }
        )
        resendTv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



       editText1.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (editText1.text.toString().length == 1) {
                    editText1.clearFocus()
                    editText2.requestFocus()
                    editText2.setCursorVisible(true)
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (editText1.text.toString().length == 0) {
                    editText1.requestFocus()
                }
            }
        })
        editText2.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (editText2.text.toString().length == 1) {
                    editText2.clearFocus()
                    editText3.requestFocus()
                    editText3.setCursorVisible(true)
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (editText2.text.toString().length == 0) {
                    editText2.requestFocus()
                }
            }
        })
        editText3.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (editText3.text.toString().length == 1) {
                    editText3.clearFocus()
                    editText4.requestFocus()
                    editText4.setCursorVisible(true)
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (editText3.text.toString().length == 0) {
                    editText3.requestFocus()
                }
            }
        })
        editText4.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (editText4.text.toString().length == 1) {
                    editText4.requestFocus()
                    editText4.setCursorVisible(true)
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (editText4.text.toString().length == 0) {
                    editText4.requestFocus()
                }
            }
        })

    }
}


