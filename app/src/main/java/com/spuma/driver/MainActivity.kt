package com.spuma.driver

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import com.example.spumadriver.R
import com.zeugmasolutions.localehelper.Locales

class MainActivity : BaseActivity() {
    lateinit var langShare: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id: String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val lang = LocaleHelper().getLanguage(this)

        val arButton = findViewById<Button>(R.id.ar_button)
        val engButton = findViewById<Button>(R.id.eng_button)

        arButton.setOnClickListener {
            updateLocale(Locales.Arabic)
            LocaleHelper().setLocale(this@MainActivity, "ar")
            recreate()
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
        engButton.setOnClickListener {
            LocaleHelper().setLocale(this@MainActivity, "en")
            recreate()
            updateLocale(Locales.English)
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
    }
}