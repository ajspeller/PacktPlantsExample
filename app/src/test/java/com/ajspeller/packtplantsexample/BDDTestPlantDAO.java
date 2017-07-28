package com.ajspeller.packtplantsexample;

import com.ajspeller.packtplantsexample.dao.IPlantDAO;
import com.ajspeller.packtplantsexample.dao.PlantDAO;
import com.ajspeller.packtplantsexample.dto.PlantDTO;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ny2va on 7/27/2017.
 */

public class BDDTestPlantDAO {

    IPlantDAO plantDAO;
    private List<PlantDTO> plants;

    @Test
    public void testPlantDAO_fetchShouldReturnResultsForRedbud()
            throws IOException, JSONException {

        givenPlantDAOIsInitialized();
        whenSearchForRedbud();
        thenVerifyAtLeastOneCercisCanadensis();

    }

    private void givenPlantDAOIsInitialized() {
        plantDAO = new PlantDAO();
    }

    private void whenSearchForRedbud() throws IOException, JSONException {
        plants = plantDAO.fetchPlants("Redbud");
    }

    private void thenVerifyAtLeastOneCercisCanadensis() {

        // assume that we do not have a match
        boolean redbudFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Cercis") &&
                    plant.getSpecies().contains("canadensis")) {
                redbudFound = true;
                break;
            }
        }

        // did we find a cerisCanadesis ?
        assertTrue(redbudFound);

        System.out.println("Test : Running redbudFound test ");
    }
}
