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

	private static final double MPG_DIVIDEND = 6760.0;
	private static final double BUS_MULTIPLIER = 0.069;
	private static final double POUNDS_CONVERSION = 0.00220462;
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity getTransportationCO2TonsPerYear(String username) {
        double result = 0.0;
        List<TransportationEntry> listAll = getAllEntriesForUser(username);
        TransportationEntry entry = listAll.get(listAll.size() - 1);
        String drivesToWork = entry.getNumTimesDriveToFromWorkWeekly();
        String mpg = entry.getMileageOfCar();
        //this is assuming that distance is put into km-- not sure if we're doing that or miles so change appropriately if it's miles
        if ( drivesToWork != null && mpg != null && Integer.parseInt(mpg) != 0) {
        		double singleTrip = POUNDS_CONVERSION * Integer.parseInt(entry.getDistanceFromWork()) * MPG_DIVIDEND/Integer.parseInt(mpg);
        		double yearlyTrips = 52 * Integer.parseInt(drivesToWork) * singleTrip;
        		String numCarpools = entry.getNumCarpools();
        		if (numCarpools != null && Integer.parseInt(numCarpools) != 0) {
        			result += yearlyTrips/Integer.parseInt(numCarpools);
        		} else {
        			result += yearlyTrips;
        		}
        }
        String bussesToWork = entry.getNumTimesBusToFromWorkWeekly();
        if (bussesToWork != null ) {
        		double singleTrip = 1000 * POUNDS_CONVERSION * Integer.parseInt(entry.getDistanceFromWork()) * BUS_MULTIPLIER;
        		double yearlyTrips = 52 * Integer.parseInt(bussesToWork) * singleTrip;
        		result += yearlyTrips;
        }
        return new ResponseEntity(result, HttpStatus.OK);
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
