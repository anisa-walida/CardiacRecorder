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

public class SignUpTest {
    @Rule
    public ActivityScenarioRule<SignUp> activityRule =
            new ActivityScenarioRule<>(SignUp.class);
    @Test
    public void testSignup(){

        onView(withId(R.id.sign)).check(matches(isDisplayed()));
        onView(withId(R.id.textv)).perform(click()); //Already have an account
        onView(withId(R.id.login)).check(matches(isDisplayed()));

    }


}