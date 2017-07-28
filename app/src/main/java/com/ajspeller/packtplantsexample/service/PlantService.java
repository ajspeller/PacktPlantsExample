package com.ajspeller.packtplantsexample.service;

import com.ajspeller.packtplantsexample.dao.IPlantDAO;
import com.ajspeller.packtplantsexample.dao.PlantDAO;
import com.ajspeller.packtplantsexample.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by ny2va on 7/27/2017.
 */

public class PlantService implements IPlantService {

    // this service layer has to access the DAO layer
    private IPlantDAO plantDAO;

    // look into using a Spring Dependency injection framework here
    public PlantService() {
        //plantDAO = new PlantJsonDAO();
        //plantDAO = new PlantDAOStub();
        plantDAO = new PlantDAO();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return plantDAO.fetchPlants(filter);
    }
}
