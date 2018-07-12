package com.example.denis.todoapp.todoList;


import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.denis.todoapp.R;
import com.example.denis.todoapp.ToDoListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ToDoListTest {
    @Rule
    public ActivityTestRule<ToDoListActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(ToDoListActivity.class);

    @Test
    public void clickOnCreateItemButton_CreateNewItem(){
        String item = "something";
        Intents.init();

        onView(withId(R.id.editText_item)).perform(typeText(item));
        onView(withId(R.id.button_add)).perform(click());

        onView(withText(item)).check(matches(isDisplayed()));
    }
}
