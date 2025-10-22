package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;

import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {

    // ✅ launch with a valid Intent containing a city name
    @Rule
    public ActivityScenarioRule<ShowActivity> scenario =
            new ActivityScenarioRule<>(
                    new Intent(ApplicationProvider.getApplicationContext(), ShowActivity.class)
                            .putExtra(ShowActivity.EXTRA_CITY, "Edmonton")
            );

    @Test
    public void testActivitySwitch() {
        onView(withId(R.id.text_city_name)).check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameIsConsistent() {
        String expectedCity = "Edmonton";
        onView(withId(R.id.text_city_name)).check(matches(withText(expectedCity)));
    }

    @Test
    public void testBackButton() {
        onView(withId(R.id.button_back)).perform(click());
    }
}