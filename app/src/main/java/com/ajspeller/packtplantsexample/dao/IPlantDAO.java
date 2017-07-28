package com.ajspeller.packtplantsexample.dao;

import com.ajspeller.packtplantsexample.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by ny2va on 7/27/2017.
 */

public interface IPlantDAO {

    List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;

}
