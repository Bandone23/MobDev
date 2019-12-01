package com.example.mobdevdogs.ui.activity

import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mobdevdogs.R
import com.example.core.extension.isNetworkAvailable
import org.jetbrains.anko.longToast
import org.jetbrains.anko.support.v4.longToast
import org.koin.android.ext.android.inject

open class BaseActivity : AppCompatActivity() {
    protected val fm: FragmentManager = supportFragmentManager
    protected var active: Fragment? = null
    protected val connectionManager: ConnectivityManager by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setSupportActionBar(findViewById(R.id.my_toolbar))
    }



    protected fun onLoading() {} //TODO: Show loading screen
    protected fun onCancel(tag: String = "BaseActivity", message: String = "onCancel") {
        Log.d(tag, message)
    }

    protected fun onError(tag: String = "BaseActivity", message: String = "onError") {
        if (connectionManager.isNetworkAvailable()) {
            longToast(getString(R.string.toast_connection_error))
        } else {
            longToast(getString(R.string.toast_are_you_connected))
        }
        Log.d(tag, message)
    }

    protected fun onUnexpectedError() {
        longToast(getString(R.string.toast_unexpected_failure))
    }
    protected fun addFragment(fragment: Fragment, tag: String) {
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.container, fragment, tag)
        transaction.commit()
        active = fragment
    }

    protected fun addFragmentToBackStack(fragment: Fragment, tag: String) {
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.container, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commit()
        active = fragment
    }
}