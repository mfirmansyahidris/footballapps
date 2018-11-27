package com.dev.fi.footballapps.ui.match

import com.dev.fi.footballapps.TestContextProvider
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.data.EventResponse
import com.dev.fi.footballapps.rest.Api
import com.dev.fi.footballapps.rest.Repository
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * ***************************************
 * created by -manca-
 * .::manca.fi@gmail.com ::.
 * ***************************************
 */

class MatchPTest {
    @Mock
    private
    lateinit var view: MatchV

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var repository: Repository

    private lateinit var presenter: MatchP

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MatchP(view, repository, gson, TestContextProvider())
    }


    @Test
    fun getPrevMatch() {
        val match: MutableList<Event> = mutableListOf()
        val response = EventResponse(match)
        val id = "4328"

        GlobalScope.launch {
            `when`(gson.fromJson(repository
                    .doRequest(Api.getPrevMatch(id)).await(),
                    EventResponse::class.java
            )).thenReturn(response)

            presenter.getPrevMatch(id)

            Mockito.verify(view).onProcess()
            Mockito.verify(view).showResult(match)
            Mockito.verify(view).onDone()
        }
    }

    @Test
    fun getNextMatchList() {
        val match: MutableList<Event> = mutableListOf()
        val response = EventResponse(match)
        val id = "4328"

        GlobalScope.launch {
            `when`(gson.fromJson(repository
                    .doRequest(Api.getNextMatch(id)).await(),
                    EventResponse::class.java
            )).thenReturn(response)

            presenter.getNextMatchList(id)

            Mockito.verify(view).onProcess()
            Mockito.verify(view).showResult(match)
            Mockito.verify(view).onDone()
        }
    }
}