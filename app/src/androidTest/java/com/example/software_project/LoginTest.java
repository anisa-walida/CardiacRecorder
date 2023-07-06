package com.example.software_project;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
    @Rule
    public ActivityScenarioRule<Login> activityRule =
            new ActivityScenarioRule<>(Login.class);
    @Test
    public void testLogin(){
        onView(withId(R.id.login)).check(matches(isDisplayed()));
        onView(withId(R.id.user)).perform(typeText("walida1907087@stud.kuet.ac.bd")); //Type a username
        onView(withId(R.id.pasd)).perform(typeText("12345678")); //Type a password
        onView(withId(R.id.button3)).perform(click()); //login button

    }


}