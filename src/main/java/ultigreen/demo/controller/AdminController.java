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
                        +"q1 VARCHAR(255) NOT NULL, "
                        +"q2 VARCHAR(255) NOT NULL, "
                        +"FOREIGN KEY(username) "
                        +"REFERENCES users(username))");

        //populate table
        List<Object[]> splitUpTransportationFootprint = Arrays.asList("username 1 1", "admin 2 2", "testUser 3 3").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        jdbcTemplate.batchUpdate("INSERT INTO transportation_footprint(username, q1, q2) VALUES (?,?,?)", splitUpTransportationFootprint);

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
