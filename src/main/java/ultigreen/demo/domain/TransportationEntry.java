package ultigreen.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "transportation_footprint")
public class TransportationEntry {
    private static final Logger log = LoggerFactory.getLogger(TransportationEntry.class);

    public TransportationEntry() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private Date date;

    private String distanceFromWork;

    private String mileageOfCar;

    private String numCarpools;

    private String numTimesDriveToFromWorkWeekly;

    private String numTimesBusToFromWorkWeekly;

    private String numTimesBikeWalkToFromWorkWeekly;

    public long getId() {
            return this.id;
        }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() { return date; }

    public void setDate(Date newDate) { this.date = newDate; }

    public String getDistanceFromWork() { return distanceFromWork; }

    public void setDistanceFromWork(String distance) { this.distanceFromWork = distance; }

    public String getMileageOfCar() { return mileageOfCar; }

    public void setMileageOfCar(String mileage) { this.mileageOfCar = mileage; }

    public String getNumCarpools() { return numCarpools; }

    public void setNumCarpools(String carpools) { this.numCarpools = carpools; }

    public String getNumTimesDriveToFromWorkWeekly() { return numTimesDriveToFromWorkWeekly; }

    public void setNumTimesDriveToFromWorkWeekly(String numTimes) { this.numTimesDriveToFromWorkWeekly = numTimes; }

    public String getNumTimesBusToFromWorkWeekly() { return numTimesBusToFromWorkWeekly; }

    public void setNumTimesBusToFromWorkWeekly(String numTimes) { this.numTimesBusToFromWorkWeekly = numTimes; }

    public String getNumTimesBikeWalkToFromWorkWeekly() { return numTimesBikeWalkToFromWorkWeekly; }

    public void setNumTimesBikeWalkToFromWorkWeekly(String numTimes) { this.numTimesBikeWalkToFromWorkWeekly = numTimes; }

}
