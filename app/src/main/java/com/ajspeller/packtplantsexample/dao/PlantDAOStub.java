package com.ajspeller.packtplantsexample.dao;

import com.ajspeller.packtplantsexample.dto.FlowerDTO;
import com.ajspeller.packtplantsexample.dto.PlantDTO;
import com.ajspeller.packtplantsexample.dto.TreeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ny2va on 7/27/2017.
 */

public class PlantDAOStub implements IPlantDAO {
    @Override
    public List<PlantDTO> fetchPlants(String filter) {

        List<PlantDTO> allPlants = new ArrayList<PlantDTO>();

        TreeDTO plant = new TreeDTO();
        plant.setGenus("Cercis");
        plant.setSpecies("canadensis");
        plant.setCommon("Eastern Redbud");
        plant.setMaxHeight(30);
        plant.setType("tree");
        plant.setFallColor("Yellowish");
        allPlants.add(plant);

        PlantDTO flower = new FlowerDTO();
        flower.setGenus("Tropoleum");
        flower.setSpecies("spp");
        plant.setType("flower");
        flower.setCommon("Nasturtium");
        allPlants.add(flower);

        return allPlants;
    }
}
