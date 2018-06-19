package ultigreen.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path="/test")
    public ResponseEntity<String> testController() {
        return new ResponseEntity<String>("Testing Admin Controller", HttpStatus.OK);
    }

    @GetMapping(path="/delete-tables")
    public ResponseEntity<String> deleteTables() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS transportation_footprint");
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
        return new ResponseEntity<String>("Deleted all tables", HttpStatus.OK);
    }

    @GetMapping(path="/generate/user-table")
    public ResponseEntity<String> generateUserTable() {
        //create table
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
        jdbcTemplate.execute("CREATE TABLE users("
                        +"id BIGINT auto_increment, "
                        +"username VARCHAR(255) NOT NULL, "
                        +"pw VARCHAR(255) NOT NULL, "
                        +"PRIMARY KEY(id) )");

        //populate table
        List<Object[]> splitUpLogins = Arrays.asList("username password", "admin admin", "testUser testPass").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        jdbcTemplate.batchUpdate("INSERT INTO users(username, pw) VALUES (?,?)", splitUpLogins);

        return new ResponseEntity<String>("Completed creating the user table", HttpStatus.OK);
    }

    @GetMapping(path="/generate/transportation-footprint-table")
    public ResponseEntity<String> generateTransportationFootprintTable() {
        //create table
        jdbcTemplate.execute("DROP TABLE IF EXISTS transportation_footprint");
        jdbcTemplate.execute("CREATE TABLE transportation_footprint"
                        +"(id SERIAL, "
                        +"username VARCHAR(255) NOT NULL, "
                        +"date DATETIME NOT NULL, "
                        +"distanceFromWork VARCHAR(255) NOT NULL, "
                        +"mileageOfCar VARCHAR(255) NOT NULL, "
                        +"numCarpools VARCHAR(255) NOT NULL, "
                        +"numTimesDriveToFromWorkWeekly VARCHAR(255) NOT NULL, "
                        +"numTimesBusToFromWorkWeekly VARCHAR(255) NOT NULL, "
                        +"numTimesBikeWalkToFromWorkWeekly VARCHAR(255) NOT NULL)");

        String sql = "INSERT INTO transportation_footprint(username,date,distanceFromWork,mileageOfCar,numCarpools," +
                "numTimesDriveToFromWorkWeekly,numTimesBusToFromWorkWeekly,numTimesBikeWalkToFromWorkWeekly) " +
                "values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,"username","2018-06-19 01:23:45","30","25","1","5","2","0");
        jdbcTemplate.update(sql,"username","2018-06-18 01:23:45","31","26","2","6","3","1");
        return new ResponseEntity<String>("Completed creating the transportation footprint table", HttpStatus.OK);
    }

    @GetMapping(path="/generate/dining-footprint-table")
    public ResponseEntity<String> generateDiningFootprintTable() {
        //TODO
        return new ResponseEntity<String>("Completed creating the dining footprint table", HttpStatus.OK);
    }

    @GetMapping(path="/generate/tableware-footprint-table")
    public ResponseEntity<String> generateTablewareFootprintTable() {
    	jdbcTemplate.execute("DROP TABLE IF EXISTS tableware_footprint");
    	
        return new ResponseEntity<String>("Completed creating the tableware footprint table", HttpStatus.OK);
    }

}
