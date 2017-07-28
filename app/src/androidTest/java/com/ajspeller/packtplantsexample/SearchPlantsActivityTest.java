package com.ajspeller.packtplantsexample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ajspeller.packtplantsexample.dto.PlantDTO;
import com.ajspeller.packtplantsexample.plantPlaces.SearchPlantsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


/**
 * Created by ny2va on 7/27/2017.
 */

@RunWith(AndroidJUnit4.class)
public class SearchPlantsActivityTest {

    @Rule
    public ActivityTestRule<SearchPlantsActivity> activityRule =
            new ActivityTestRule<SearchPlantsActivity>(SearchPlantsActivity.class);

    @Test
    public void searchForRedbudShouldReturnAtLeastOneResult() {
        Context context = InstrumentationRegistry.getContext();

        onView(withId(R.id.actPlantName)).perform(typeText("Redbud"), closeSoftKeyboard());
        onView(withId(R.id.searchBtn)).perform(click());

        List<PlantDTO> plants = activityRule.getActivity().getPlants();

        assertThat(plants, not(empty()));
    }
}