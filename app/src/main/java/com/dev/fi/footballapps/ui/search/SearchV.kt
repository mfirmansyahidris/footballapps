package com.dev.fi.footballapps.ui.search

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface SearchV {
    fun onProcess()
    fun onDone()
    fun onEmpyResult()
    fun showResult(data: List<Any>)
}