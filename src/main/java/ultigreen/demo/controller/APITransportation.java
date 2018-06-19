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
    public ResponseEntity<String> addEntryForUser(@RequestBody TransportationEntry entry){
        if (entry != null) {
            return transportationService.addEntryForUser(entry);
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

}
