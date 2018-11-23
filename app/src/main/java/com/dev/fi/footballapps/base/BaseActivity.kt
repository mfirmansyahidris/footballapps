package com.dev.fi.footballapps.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

abstract class BaseActivity : AppCompatActivity() {
    protected var toolbar: Toolbar? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        if (getToolbarResource() != 0) {
            toolbar = findViewById(getToolbarResource())
            if (getToolbarTitle() != "") toolbar?.title = getToolbarTitle()
            setSupportActionBar(toolbar)
            supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        mainCode()
    }

    protected abstract fun getLayoutResource(): Int
    protected abstract fun getToolbarResource(): Int
    protected abstract fun getToolbarTitle(): String
    protected abstract fun mainCode()
}