package com.example.software_project;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;


public class Insert_Medical_ReportTest {
    @Rule
    public ActivityScenarioRule<Insert_Medical_Report> activityRule =
            new ActivityScenarioRule<>(Insert_Medical_Report.class);
    @Test
    public void testCheckAppName() {
        onView(withText("Software_project")).check(matches(isDisplayed()));
    }

    @Test
    public void testInsert(){

        onView(withId(R.id.nill)).perform(typeText("Walida"));
        onView(withId(R.id.gastric)).perform(typeText("04/07/23"));
        onView(withId(R.id.glucose)).perform(typeText("11:48"));
        onView(withId(R.id.sugar)).perform(typeText("80"));
        onView(withId(R.id.sodium)).perform(typeText("120"));
        onView(withId(R.id.urin)).perform(typeText("65"));
        Espresso.pressBack();
        onView(withId(R.id.henlo)).perform(typeText("New Record"));
        Espresso.pressBack();
        onView(withId(R.id.button)).perform(click());
    }

}