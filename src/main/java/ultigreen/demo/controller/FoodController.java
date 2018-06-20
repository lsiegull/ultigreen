package ultigreen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import ultigreen.demo.services.FoodService;
import ultigreen.demo.domain.FoodInfoResponse;
import ultigreen.demo.domain.FoodEntry;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    public FoodController() {}

    @PostMapping(path="/create")
    public ResponseEntity<String> create(@RequestBody FoodInfoResponse foodItems) {
        foodService.insertIntoDatabase(foodItems.getUsername(), foodItems.getFoodItems());
        return new ResponseEntity<>("Added food items to database", HttpStatus.CREATED);
    }

    @PutMapping(path="/update")
    public ResponseEntity<String> update(@RequestBody FoodInfoResponse foodItems) {
        System.out.println(foodItems);
        foodService.updateDatabase(foodItems.getUsername(), foodItems.getFoodItems());
        return new ResponseEntity<>("Updated food items in database", HttpStatus.OK);
    }

    @GetMapping(path="/getAll")
    public ResponseEntity<List<FoodEntry>> getAll(@RequestParam String username) {
        List<FoodEntry> food = foodService.getAllFromDatabase(username);
        System.out.println(food);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @GetMapping(path="/calculate")
    public ResponseEntity<Double> calculate() {
        return new ResponseEntity<Double>(foodService.calculateCarbonFootprint(), HttpStatus.OK);
    }
}