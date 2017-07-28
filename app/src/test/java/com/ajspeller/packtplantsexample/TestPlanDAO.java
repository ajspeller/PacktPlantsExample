package com.ajspeller.packtplantsexample;

import com.ajspeller.packtplantsexample.dao.IPlantDAO;
import com.ajspeller.packtplantsexample.dao.PlantDAOStub;
import com.ajspeller.packtplantsexample.dto.PlantDTO;

import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ny2va on 7/27/2017.
 */

public class TestPlanDAO {

    // define a DAO variable for the DAO that we are testing
    IPlantDAO plantDAO;

    //runs only once before all of the tests
    @BeforeClass
    public static void setupAllTests() {
        // use logging to logcat, only using System.out.println to easily see the results of the run
        System.out.println("BeforeClass:  running init for ALL tests");
    }

    // runs only once at the end of all the tests
    @AfterClass
    public static void teardownAllTests() {
        System.out.println("AfterClass : tearing down after ALL tests");
    }

    // runs before each test
    @Before
    public void setup() {
        plantDAO = new PlantDAOStub();
        System.out.println("Before: running init before each test");
    }

    @Test
    public void testPlanDAO_searchForRedbudShouldReturnAtLeastOneResult()
            throws IOException, JSONException {

        // assume that we do not have a match
        boolean redbudFound = false;

        List<PlantDTO> plants = plantDAO.fetchPlants("Redbud");

        for (PlantDTO plant : plants) {
            if (plant.getCommon().contains("Redbud")) {
                redbudFound = true;
                break;
            }
        }

        // did we find a redbud ?
        assertTrue(redbudFound);

        System.out.println("Test : Running redbud test ");
    }

    @Test
    public void testPlanDAO_searchForOakShouldReturnAtLeastOneWhiteOak()
            throws IOException, JSONException {

        // assume that we do not have a match
        boolean whiteOakFound = false;

        List<PlantDTO> plants = plantDAO.fetchPlants("Oak");

        for (PlantDTO plant : plants) {
            if (plant.getGenus().equalsIgnoreCase("Quercus") &&
                    plant.getSpecies().contains("alba")) {
                whiteOakFound = true;
                break;
            }
        }

        // did we find a whiteoak ?
        assertTrue(whiteOakFound);

        System.out.println("Test : Running whiteoak test ");
    }

    @Test
    public void testPlantDAO_searchForEShouldReturnAtLeastTwoResults()
            throws IOException, JSONException {
        List<PlantDTO> plants = plantDAO.fetchPlants("e");
        int size = plants.size();
        boolean atLeastTwo = size > 2;
        assertFalse(atLeastTwo);
        System.out.println("Test : At least 2 plants with the letter 'e'");
    }

    // runs after each test
    @After
    public void teardown() {
        System.out.println("After : tearing down each test");
    }

}
