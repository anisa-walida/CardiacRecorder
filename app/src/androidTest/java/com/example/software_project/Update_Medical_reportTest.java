package com.example.software_project;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class Update_Medical_reportTest {
    @Rule
    public ActivityScenarioRule<Update_Medical_report> activityRule =
            new ActivityScenarioRule<>(Update_Medical_report.class);
    @Test

    public void testUpdate(){

        Espresso.onView(withId(R.id.recycler)).perform(longClick());


        onView(withId(R.id.nille)).perform(typeText("Walida"));
        onView(withId(R.id.gastrice)).perform(typeText("04/07/23"));
        onView(withId(R.id.glucosee)).perform(typeText("11:48"));
        onView(withId(R.id.sugare)).perform(typeText("80"));
        onView(withId(R.id.sodiume)).perform(typeText("120"));
        onView(withId(R.id.urine)).perform(typeText("65"));
        Espresso.pressBack();
        onView(withId(R.id.henloe)).perform(typeText("New Record"));
        Espresso.pressBack();
        onView(withId(R.id.ebutton)).perform(click());
    }

}