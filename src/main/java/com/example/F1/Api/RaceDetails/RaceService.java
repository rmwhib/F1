package com.example.F1.Api.RaceDetails;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    //public List<Race> getRaces() throws URISyntaxException, IOException, InterruptedException {
    public List getRaces() throws URISyntaxException, IOException, InterruptedException {
        URL url = new URL("https://v1.formula-1.api-sports.io/races?last=2&season=2021&type=race"); //just a string

        HttpURLConnection fixerConnection = (HttpURLConnection) url.openConnection();
        fixerConnection.setRequestProperty("x-rapidapi-key", "067e194420437eb916ea0710bf75a011");
        fixerConnection.setRequestProperty("accept", "application/json");
        fixerConnection.setRequestMethod("GET");
        BufferedReader jsonData = new BufferedReader(new
                InputStreamReader(fixerConnection.getInputStream()));
        JsonObject allData = new JsonParser().parse(jsonData).getAsJsonObject();
        // Now Take Rates as JSON Object and capture it in a Map.
       // System.out.println(allData.getAsJsonObject("response"));
        JsonArray rates =  allData.getAsJsonArray("response");

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < rates.size(); i ++){
            JsonObject array = (JsonObject) rates.get(i);
            JsonObject comp =   (JsonObject) array.get("competition");
            JsonPrimitive nameofrace = (JsonPrimitive) comp.get("name");
            list.add(nameofrace.getAsString());
        }



       // Map<String, JsonElement> entries = rates.entrySet();

//        // Connect to the URL using java's native library
//        URL url = new URL(sURL);
//        URLConnection request = url.openConnection();
//        request.setRequestProperty("x-rapidapi-key", "067e194420437eb916ea0710bf75a011");
//
//        request.setRequestProperty("accept", "application/json");
//        request.connect();
//
//
//        //Convert to a JSON object to print data
//        com.google.gson.JsonParser jp = new JsonParser(); //from gson
//
//        JsonParser parser = new JsonParser();
//
//        //JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//        JsonArray root = (JsonArray) parser.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//
//        System.out.println("what is this" + root);
//
//        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object
//
//        JsonArray results = (JsonArray) rootobj.get("response"); //just grab the zipcode
//
//        JsonObject res2 =  (JsonObject) results.get(1);
//        JsonObject res3 =   (JsonObject) res2.get("competition");
//        JsonPrimitive res4 = (JsonPrimitive) res3.get("name");

        return list;

    }

//    public void addNewRace(Race race) {
//        Optional<Race> racebyname = raceRepository
//                .findRaceByName(race.getFirstRace());
//        if (racebyname.isPresent()){
//            throw new IllegalStateException("name exists");
//        }
//        System.out.println(race);
//    }

//    public void deleteRace(Long raceID){
////        Optional<Race> deletebyname = raceRepository
////                .deleteRaceByName(race.getFirstRace());
//        raceRepository.deleteById(raceID);
//    }

//    @Transactional //dont mess with Database
//    public void updaupdateName(String raceName){
//        //race.set
//    }
}
