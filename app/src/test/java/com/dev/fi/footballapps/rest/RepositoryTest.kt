package com.dev.fi.footballapps.rest

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

/**
 * ***************************************
 * created by -manca-
 * .::manca.fi@gmail.com ::.
 * ***************************************
 */

class RepositoryTest {

    @Test
    fun doRequest() {
        val apiRepository = Mockito.mock(Repository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328"
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }
}