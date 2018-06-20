package ultigreen.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ultigreen.demo.TransportationService;
import ultigreen.demo.domain.TransportationEntry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/transportation")
public class APITransportation {

    private static final Logger log = LoggerFactory.getLogger(APITransportation.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TransportationService transportationService;

    public APITransportation() {

    }

    @PostMapping(path="/addEntry")
    public ResponseEntity<String> addEntry(@RequestBody TransportationEntry entry){
        if (entry != null) {
            return transportationService.addEntry(entry);
        }
        return new ResponseEntity<>("Error creating entry", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path="/updateEntry")
    public ResponseEntity<String> updatEntry(@RequestBody TransportationEntry entry){
        if (entry != null) {
            return transportationService.updateEntry(entry);
        }
        return new ResponseEntity<>("Error creating entry", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path="/getLatest/{username}")
    public ResponseEntity<TransportationEntry> getLatestDataForUser(@PathVariable("username") String username) {
        if (username == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return transportationService.getLatestDataForUser(username);
    }

    @GetMapping(path="/getTransportationCO2/{username}")
    public ResponseEntity<String> getTransportationCO2TonsPerYear(@PathVariable("username") String username) {
        if (username != null) {
            return transportationService.getTransportationCO2TonsPerYear(username);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
