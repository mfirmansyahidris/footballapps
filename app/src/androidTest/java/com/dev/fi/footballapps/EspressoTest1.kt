package com.dev.fi.footballapps

import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.dev.fi.footballapps.ui.HomeActivity
import com.dev.fi.footballapps.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballapps.ui.detailTeam.DetailTeamActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

@RunWith(AndroidJUnit4::class)
class EspressoTest1 {
    @Rule
    @JvmField
    var mainActivity = ActivityTestRule(HomeActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun action() {
        registerIdlingResources(HomeActivity.prevMatchCountingIdlingResource)
        onView(ViewMatchers.withId(R.id.navmenu_teams)).perform(click())

        registerIdlingResources(HomeActivity.teamCountingIdlingResource)
        onView(ViewMatchers.withId(R.id.navmenu_favorites)).perform(click())

        onView(ViewMatchers.withId(R.id.navmenu_match)).perform(click())

        registerIdlingResources(HomeActivity.prevMatchCountingIdlingResource)
        onView(withId(R.id.rv_match_prev)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))

        registerIdlingResources(DetailMatchActivity.detailMatchCountingIdlingResouce)
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()

        registerIdlingResources(HomeActivity.prevMatchCountingIdlingResource)

        onView(withText("Next")).perform(click())
        onView(withId(R.id.sp_leagues)).perform(click())
        onView(withText("Spanish La Liga")).perform(click())
        registerIdlingResources(HomeActivity.nextMatchCountingIdlingResource)
        onView(withId(R.id.rv_match_next)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))

        registerIdlingResources(DetailMatchActivity.detailMatchCountingIdlingResouce)
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()

        onView(ViewMatchers.withId(R.id.navmenu_teams)).perform(click())
        onView(withId(R.id.sp_leagues)).perform(click())
        onView(withText("Spanish La Liga")).perform(click())
        registerIdlingResources(HomeActivity.teamCountingIdlingResource)
        onView(withId(R.id.rv_teams)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))
        onView(withText("Player")).perform(click())

        registerIdlingResources(DetailTeamActivity.playerCountingIdlingResource)

        onView(withId(R.id.rv_players)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))
        SystemClock.sleep(1000 * 1)
        pressBack()
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()
        registerIdlingResources(HomeActivity.prevMatchCountingIdlingResource)

        onView(ViewMatchers.withId(R.id.navmenu_favorites)).perform(click())
        onView(withId(R.id.rv_match)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()
    }
}