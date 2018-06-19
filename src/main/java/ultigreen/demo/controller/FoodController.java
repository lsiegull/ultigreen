package ultigreen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import ultigreen.demo.services.FoodService;
import ultigreen.demo.domain.Food;
import ultigreen.demo.domain.FoodInfoResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    public FoodController() {}

    @PostMapping(path="/create")
    public ResponseEntity<String> create(@RequestBody FoodInfoResponse foodItems) {
        foodService.insertIntoDatabase(foodItems.getFoodItems());
        return new ResponseEntity<>("Added food items to database", HttpStatus.CREATED);
    }

    @GetMapping(path="/calculate")
    public ResponseEntity<Double> calculate() {
        return new ResponseEntity<Double>(foodService.calculateCarbonFootprint(), HttpStatus.OK);
    }
}