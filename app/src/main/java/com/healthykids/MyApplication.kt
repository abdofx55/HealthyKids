package com.healthykids

import android.app.Application
import androidx.core.content.res.ResourcesCompat
import com.example.healthykids.R
import dagger.hilt.android.HiltAndroidApp
import es.dmoral.toasty.Toasty

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeToasty()
    }

    private fun initializeToasty() {
        ResourcesCompat.getFont(this, R.font.regular_400)?.let {
            Toasty.Config.getInstance()
                .tintIcon(true)
                .setRTL(true)
                .setTextSize(15)
                .setToastTypeface(it)
                .allowQueue(false)
                .apply()
        }
    }
}

