package com.ajspeller.packtplantsexample.dao;

import com.ajspeller.packtplantsexample.dto.PlantDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ny2va on 7/27/2017.
 */

public class PlantDAO implements IPlantDAO {

    private NetworkDAO networkDAO;

    public PlantDAO() {
        networkDAO = new NetworkDAO();
    }

    @Override

    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {

        ArrayList<PlantDTO> allPlants = new ArrayList<PlantDTO>();

        String request =
                networkDAO.fetch
                        ("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name="
                                + filter);

        // entire JSON string
        JSONObject root = new JSONObject(request);

        // get the first array, which is the array of named plants
        JSONArray plants = root.getJSONArray("plants");

        for (int i = 0; i < plants.length(); i++) {
            // represents individual plants
            JSONObject jsonObject = plants.getJSONObject(i);
            int id = jsonObject.getInt("id");
            String genus = jsonObject.getString("genus");
            String species = jsonObject.getString("species");
            String cultivar = jsonObject.getString("cultivar");
            String common = jsonObject.getString("common");

            // put these into the PlantDTO
            PlantDTO plantDTO = new PlantDTO();
            plantDTO.setGuid(id);
            plantDTO.setGenus(genus);
            plantDTO.setSpecies(species);
            plantDTO.setCultivar(cultivar);
            plantDTO.setCommon(common);

            // add this plant to the collection
            allPlants.add(plantDTO);
        }

        System.out.println("FETCH COMPLETE : All plants added to the collection");
        return allPlants;
    }
}
