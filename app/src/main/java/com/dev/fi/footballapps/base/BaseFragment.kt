package com.dev.fi.footballschedule2.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

abstract class BaseFragment : Fragment() {
    protected lateinit var activity: AppCompatActivity

    protected abstract fun getLayoutResource(): Int
    protected abstract fun mainCode()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        return inflater.inflate(getLayoutResource(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainCode()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as AppCompatActivity
    }

}