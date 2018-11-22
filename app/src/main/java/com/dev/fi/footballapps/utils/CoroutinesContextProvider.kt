package com.dev.fi.footballschedule2.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
}