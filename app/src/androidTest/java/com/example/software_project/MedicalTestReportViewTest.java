package com.example.software_project;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;



import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import static org.junit.Assert.*;

import android.os.SystemClock;

public class MedicalTestReportViewTest {
    @Rule
    public ActivityScenarioRule<MedicalTestReportView> activityRule =
            new ActivityScenarioRule<>(MedicalTestReportView.class);


    @Test
    public void testUpdate() {
        Espresso.onView(withId(R.id.medTestReport)).perform(longClick());
        //SystemClock.sleep(1000);
        //onView(withId(R.id.update)).check(matches(isDisplayed()));
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
    @Test
    public void testDelete() {

            SystemClock.sleep(5000);
            Espresso.onView(withId(R.id.medTestReport)).perform(longClick());
            SystemClock.sleep(1000);
            onView(withId(R.id.buttond)).perform(click());
            SystemClock.sleep(5000);


    }

}