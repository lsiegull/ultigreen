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
import ultigreen.demo.domain.FoodEntry;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    public FoodController() {}

    @PostMapping(path="/create")
    public ResponseEntity<String> create(@RequestBody FoodEntry entry) {
        if (entry == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return foodService.insert(entry);
    }

    @PutMapping(path="/update")
    public ResponseEntity<String> update(@RequestBody FoodEntry entry) {
        if (entry == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return foodService.update(entry);
    }

    @GetMapping(path="/getAll")
    public ResponseEntity<FoodEntry> getAll(@RequestParam String username) {
        if (username == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return foodService.getAll(username);
    }

    @GetMapping(path="/calculate")
    public ResponseEntity<Double> calculate(@RequestParam String username) {
        if (username == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return foodService.calculate(username);
    }
}