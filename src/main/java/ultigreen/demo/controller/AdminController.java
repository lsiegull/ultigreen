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
                        +"date DATE NOT NULL, "
                        +"distanceFromWork VARCHAR(255) NOT NULL, "
                        +"mileageOfCar VARCHAR(255) NOT NULL, "
                        +"numCarpools VARCHAR(255) NOT NULL, "
                        +"numTimesDriveToFromWorkWeekly VARCHAR(255) NOT NULL, "
                        +"numTimesBusToFromWorkWeekly VARCHAR(255) NOT NULL, "
                        +"numTimesBikeWalkToFromWorkWeekly VARCHAR(255) NOT NULL)");

        String sql = "INSERT INTO transportation_footprint(username,date,distanceFromWork,mileageOfCar,numCarpools," +
                "numTimesDriveToFromWorkWeekly,numTimesBusToFromWorkWeekly,numTimesBikeWalkToFromWorkWeekly) " +
                "values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,"username","2018-06-18","31","26","2","6","3","1");
        jdbcTemplate.update(sql,"username","2018-06-19","30","25","1","5","2","0");
        return new ResponseEntity<String>("Completed creating the transportation footprint table", HttpStatus.OK);
    }

    @GetMapping(path="/generate/dining-footprint-table")
    public ResponseEntity<String> generateDiningFootprintTable() {
        //create table
        jdbcTemplate.execute("DROP TABLE IF EXISTS dining_footprint");
        jdbcTemplate.execute("CREATE TABLE dining_footprint"
                        +"(id SERIAL, "
                        +"username VARCHAR(255) NOT NULL, "
                        +"lamb DECIMAL(18,4) NOT NULL, "
                        +"beef DECIMAL(18,4) NOT NULL, "
                        +"cheese DECIMAL(18,4) NOT NULL, "
                        +"pork DECIMAL(18,4) NOT NULL, "
                        +"turkey DECIMAL(18,4) NOT NULL, "
                        +"chicken DECIMAL(18,4) NOT NULL, "
                        +"tuna DECIMAL(18,4) NOT NULL, "
                        +"eggs DECIMAL(18,4) NOT NULL, "
                        +"potatoes DECIMAL(18,4) NOT NULL, "
                        +"rice DECIMAL(18,4) NOT NULL, "
                        +"nuts DECIMAL(18,4) NOT NULL, "
                        +"beans DECIMAL(18,4) NOT NULL, "
                        +"tofu DECIMAL(18,4) NOT NULL, "
                        +"vegetables DECIMAL(18,4) NOT NULL, "
                        +"milk DECIMAL(18,4) NOT NULL, "
                        +"fruit DECIMAL(18,4) NOT NULL, "
                        +"date DATE NOT NULL)"
                        );
        String cols = "INSERT INTO dining_footprint(username,lamb,beef,cheese,pork,turkey,chicken,tuna,eggs,potatoes,rice,nuts,beans,tofu,milk,vegetables,fruit,date)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(cols, "username", 0, 1, 2, 1, 0, 1, 0, 2, 1, 2, 3, 4, 0, 2, 5, 2, "2018-06-19");
        return new ResponseEntity<String>("Completed creating the dining footprint table", HttpStatus.OK);
    }

    @GetMapping(path="/generate/reusables-footprint-table")
    public ResponseEntity<String> generateReusablesFootprintTable() {
    	jdbcTemplate.execute("DROP TABLE IF EXISTS reusables_footprint");
    	jdbcTemplate.execute("CREATE TABLE reusables_footprint"
    			+"(id SERIAL, "
    			+"user VARCHAR(255) NOT NULL, "
    			+"plastic VARCHAR(255) NOT NULL, "
    			+"paper VARCHAR(255) NOT NULL, "
    			+"styrofoam VARCHAR(255) NOT NULL, "
    			+"bagasse VARCHAR(255) NOT NULL, "
    			+ "date DATE NOT NULL)"
    			 );
    	String cols = "INSERT INTO reusables_footprint(user,plastic,paper,styrofoam,bagasse,date)" +
                "values (?,?,?,?,?,?)";
    	jdbcTemplate.update(cols, "username", "2", "4", "5", "8", "2018-06-19");
        return new ResponseEntity<String>("Completed creating the reusables footprint table\n", HttpStatus.OK);
    }

}
