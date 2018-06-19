import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ultigreen.demo.services.FoodService;
import ultigreen.demo.domain.Food;

@RestController
@RequestMapping(path="/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping(path="/create")
    public ResponseEntity<String> create(@RequestParam Food[] items) {
        foodService.insertIntoDatabase(items);
        return new ResponseEntity<>("Added food items to database", HttpStatus.CREATED);
    }

    @GetMapping(path="/calculate")
    public ResponseEntity<Double> calculate() {
        return new ResponseEntity<Double>(foodService.calculateCarbonFootprint(), HttpStatus.OK);
    }
}