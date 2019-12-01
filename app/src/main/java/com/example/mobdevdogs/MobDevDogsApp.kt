package com.example.mobdevdogs

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.example.mobdevdogs.di.appModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


const val URL_BASE_EXPERIENCE_API = "http://192.168.20.5:4000/api/"
const val DATABASE_NAME = "basquetcamp.sqlite"
const val DATABASE_VERSION = 2
const val TABLE_MATCHES ="matches"
const val TABLE_USERS ="users"
open class MobDevDogsApp : Application() {

     override fun onCreate() {
         super.onCreate()
         initKoin()
         AndroidThreeTen.init(this)
     }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MobDevDogsApp)
            modules(listOf(appModule))
        }
    }
}