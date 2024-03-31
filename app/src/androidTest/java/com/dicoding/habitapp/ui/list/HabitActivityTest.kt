package com.dicoding.habitapp.ui.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.habitapp.R
import com.dicoding.habitapp.ui.add.AddHabitActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed
class HabitActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(HabitListActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        Intents.init()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun whenUserTapAddHabitShouldDisplayAddHabitActivity() {
        onView(withId(R.id.fab)).check(matches(isDisplayed())).perform(click())

        onView(withId(R.id.add_ed_title)).check(matches(isDisplayed()))
        onView(withId(R.id.add_ed_minutes_focus)).check(matches(isDisplayed()))
        onView(withId(R.id.sp_priority_level)).check(matches(isDisplayed()))
        onView(withId(R.id.add_tv_start_time)).check(matches(isDisplayed()))

        intended(hasComponent(AddHabitActivity::class.java.name))
    }
}