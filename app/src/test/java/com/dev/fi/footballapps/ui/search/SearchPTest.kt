package com.dev.fi.footballapps.ui.search

import com.dev.fi.footballapps.TestContextProvider
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.data.EventResponse
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.data.TeamResponse
import com.dev.fi.footballapps.rest.Api
import com.dev.fi.footballapps.rest.Repository
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
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

class SearchPTest {
    @Mock
    private
    lateinit var view: SearchV

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var repository: Repository

    private lateinit var presenter: SearchP

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchP(view, repository, gson, TestContextProvider())
    }

    @Test
    fun getSearchMatch() {
        val match: MutableList<Event> = mutableListOf()
        val response = EventResponse(match)
        val key = "bar"

        GlobalScope.launch {
            `when`(gson.fromJson(repository
                    .doRequest(Api.getSearchMatch(key)).await(),
                    EventResponse::class.java
            )).thenReturn(response)

            presenter.getSearchMatch(key)

            Mockito.verify(view).onProcess()
            Mockito.verify(view).onEmpyResult()
            Mockito.verify(view).showResult(match)
            Mockito.verify(view).onDone()
        }
    }

    @Test
    fun getSearchTeam() {
        val match: MutableList<Team> = mutableListOf()
        val response = TeamResponse(match)
        val key = "bar"

        GlobalScope.launch {
            `when`(gson.fromJson(repository
                    .doRequest(Api.getSearchTeam(key)).await(),
                    TeamResponse::class.java
            )).thenReturn(response)

            presenter.getSearchMatch(key)

            Mockito.verify(view).onProcess()
            Mockito.verify(view).onEmpyResult()
            Mockito.verify(view).showResult(match)
            Mockito.verify(view).onDone()
        }
    }
}