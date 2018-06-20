package ultigreen.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ultigreen.demo.domain.TransportationEntry;

import java.util.List;

@Service
public class TransportationService {

    private static final Logger log = LoggerFactory.getLogger(TransportationService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ResponseEntity<String> addEntry(TransportationEntry entry) {
        String sql = "INSERT INTO transportation_footprint(username,date,distanceFromWork,mileageOfCar,numCarpools," +
                "numTimesDriveToFromWorkWeekly,numTimesBusToFromWorkWeekly,numTimesBikeWalkToFromWorkWeekly) " +
                "values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,entry.getUsername(),entry.getDate(),entry.getDistanceFromWork(),
                entry.getMileageOfCar(),entry.getNumCarpools(),entry.getNumTimesDriveToFromWorkWeekly(),
                entry.getNumTimesBusToFromWorkWeekly(),entry.getNumTimesBikeWalkToFromWorkWeekly());
        return new ResponseEntity<>("Added new transportation entry", HttpStatus.OK);
    }

    public ResponseEntity<String> updateEntry(TransportationEntry entry) {
        String sql = "UPDATE transportation_footprint SET distanceFromWork=?,mileageOfCar=?,numCarpools=?,"+
                "numTimesDriveToFromWorkWeekly=?,numTimesBusToFromWorkWeekly=?,numTimesBikeWalkToFromWorkWeekly=? " +
                "WHERE date=? and username=?";
        jdbcTemplate.update(sql,entry.getDistanceFromWork(),
                entry.getMileageOfCar(),entry.getNumCarpools(),entry.getNumTimesDriveToFromWorkWeekly(),
                entry.getNumTimesBusToFromWorkWeekly(),entry.getNumTimesBikeWalkToFromWorkWeekly(),
                entry.getDate(), entry.getUsername());
        return new ResponseEntity<>("Updated transportation entry", HttpStatus.OK);
    }

    public ResponseEntity<String> getTransportationCO2TonsPerYear(String username) {
        String result = "";
        double distToWork = 2.0;
        double milesPerGallon = 25.0;
        double gallons = (520 * distToWork) / milesPerGallon;
        double resultNum = 19.6 * gallons / 2204.62;
        return new ResponseEntity<>("dummyCO2Tons", HttpStatus.OK);
    }

    public ResponseEntity<TransportationEntry> getLatestDataForUser(String username) {
        List<TransportationEntry> results = getAllEntriesForUser(username);
        return new ResponseEntity<TransportationEntry>(results.get(0), HttpStatus.OK);
    }

    private List<TransportationEntry> getAllEntriesForUser(String username) {
        String sql = "SELECT * FROM transportation_footprint tf WHERE tf.username = ? ";
        RowMapper<TransportationEntry> rowMapper = new BeanPropertyRowMapper<TransportationEntry>(TransportationEntry.class);
        List<TransportationEntry> results = jdbcTemplate.query(sql, rowMapper, username);
        return results;
    }
}
