package com.example.F1.Api.RaceDetails;

import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/race")
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
//    public List<Race> Hello() throws URISyntaxException, IOException, InterruptedException {
//        return raceService.getRaces();
//        //return List.of(new Race(1L, "Britian", "UK" ));
//    }
    public List Hello() throws URISyntaxException, IOException, InterruptedException {
        return raceService.getRaces();
        //return List.of(new Race(1L, "Britian", "UK" ));
    }

//    @PostMapping
//    public void addnewrace(@RequestBody Race race){
//        raceService.addNewRace(race);
//    }
//
//    @DeleteMapping(path = "{raceid}")
//    //public void deleterace(@RequestBody Race race){
//    public void deleterace(@PathVariable("studentId") Long id){
//        raceService.deleteRace(id);
//    }
//
//    @PutMapping(path = "{racename}" )
//    public void updateRacename(@RequestBody("racename") String racename){
//        raceService.updateName(racename);
//    }
}
