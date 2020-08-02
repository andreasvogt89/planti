package com.planti.webcontroller;

import com.planti.database.Plant;
import com.planti.database.PlantHistoryLog;
import com.planti.database.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

import static java.util.stream.Collectors.toCollection;

@CrossOrigin
@RestController
@Component
@Configuration
public class ApiController {
    private final PlantRepository plantRepository;



    @Autowired
    public ApiController(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }

    @GetMapping(value ="/plantNames")
    public ArrayList<String> getPlantNames(){
        return plantRepository.findAll().stream()
                .map(Plant::getName)
                .collect(toCollection(ArrayList::new));
    }

    @GetMapping(value ="/plants")
    public ArrayList<Plant> getPlants(){
        return new ArrayList<>(plantRepository.findAll());
    }

    @PostMapping(value ="/newPlant")
    public ResponseEntity<Object> createNewPlant(@RequestBody Plant plant){
        try {
            plantRepository.save(plant);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value ="/editPlant")
    public ResponseEntity<Object> editPlant(@RequestBody Plant plant){
        try {
            plantRepository.save(plant);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/plantWaterEntry")
    public ResponseEntity<Object> createNewPlant(@RequestBody JSON_WaterEntry waterEntry){
        try {
            Plant updatePlant = plantRepository.findByName(waterEntry.getPlantName());
            updatePlant.setLastWatering(waterEntry.getWateringDate());
            updatePlant.setNextWatering(new Date(waterEntry.getWateringDate().getTime() +
                    updatePlant.getTimeToNextWatering()));
            updatePlant.getPlantHistoryLog().add(new PlantHistoryLog(updatePlant,waterEntry.getWateringDate()));
            plantRepository.save(updatePlant);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Exception if wrong URL tipped
     */
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "404 The resource you seeking for does not exist") //404
    private static class FoundException extends RuntimeException {
    }

}
