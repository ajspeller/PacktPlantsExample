package com.ajspeller.packtplantsexample.service;

import com.ajspeller.packtplantsexample.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Business Logic for fetching and managing plants
 * Created by ny2va on 7/27/2017.
 */

public interface IPlantService {
    List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;
}
