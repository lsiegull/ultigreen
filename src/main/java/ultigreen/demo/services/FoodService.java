package ultigreen.demo.services;

import ultigreen.demo.domain.FoodEntry;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class FoodService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final int GRAMS = 1000;
    private static final int DAYS = 7;
    private static final int WEEKS = 52;
    private static final double LAMB = 39.2;
    private static final double BEEF = 27.0;
    private static final double CHEESE = 13.5;
    private static final double PORK = 12.1;
    private static final double TURKEY = 10.9;
    private static final double CHICKEN = 6.9;
    private static final double TUNA = 6.1;
    private static final double EGGS = 4.8;
    private static final double POTATOES = 2.9;
    private static final double RICE = 2.7;
    private static final double NUTS = 2.3;
    private static final double BEANS = 2.0;
    private static final double TOFU = 2.0;
    private static final double VEGETABLES = 2.0;
    private static final double MILK = 1.9;
    private static final double FRUIT = 1.1;

    public ResponseEntity<String> insert(FoodEntry entry) {
        String cols = "INSERT INTO dining_footprint(username,lamb,beef,cheese,pork,turkey,chicken,tuna,eggs,potatoes,rice,nuts,beans,tofu,milk,vegetables,fruit,date)"
            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(cols, entry.getUsername(), entry.getLamb(), entry.getBeef(), entry.getCheese(), entry.getPork(), entry.getTurkey(), entry.getChicken(),
            entry.getTuna(), entry.getEggs(), entry.getPotatoes(), entry.getRice(), entry.getNuts(), entry.getBeans(), entry.getTofu(), entry.getMilk(),
            entry.getVegetables(), entry.getFruit(), entry.getDate());
        return new ResponseEntity<>("Successfully created new database entries", HttpStatus.CREATED);
    }

    public ResponseEntity<String> update(FoodEntry entry) {
        String cols = "UPDATE dining_footprint SET lamb=?,beef=?,cheese=?,pork=?,turkey=?,chicken=?,tuna=?,eggs=?,potatoes=?,rice=?,nuts=?,beans=?,tofu=?,milk=?,vegetables=?,fruit=? WHERE username=? and date=?";
        jdbcTemplate.update(cols, entry.getLamb(), entry.getBeef(), entry.getCheese(), entry.getPork(), entry.getTurkey(), entry.getChicken(),
            entry.getTuna(), entry.getEggs(), entry.getPotatoes(), entry.getRice(), entry.getNuts(), entry.getBeans(), entry.getTofu(), entry.getMilk(),
            entry.getVegetables(), entry.getFruit(), entry.getUsername(), entry.getDate());
        return new ResponseEntity<>("Successfully updated existing database entries", HttpStatus.OK);
    }

    public ResponseEntity<FoodEntry> getAll(String username) {
        return new ResponseEntity<>(getRecent(username), HttpStatus.OK);
    }

    public ResponseEntity<Double> calculate(String username) {
        double footprint = 0.0;
        FoodEntry entry = getRecent(username);
        footprint += entry.getLamb().doubleValue() / GRAMS * DAYS * WEEKS * LAMB;
        footprint += entry.getBeef().doubleValue() / GRAMS * DAYS * WEEKS * BEEF;
        footprint += entry.getCheese().doubleValue() / GRAMS * DAYS * WEEKS * CHEESE;
        footprint += entry.getPork().doubleValue() / GRAMS * DAYS * WEEKS * PORK;
        footprint += entry.getTurkey().doubleValue() / GRAMS * DAYS * WEEKS * TURKEY;
        footprint += entry.getChicken().doubleValue() / GRAMS * DAYS * WEEKS * CHICKEN;
        footprint += entry.getTuna().doubleValue() / GRAMS * DAYS * WEEKS * TUNA;
        footprint += entry.getEggs().doubleValue() / GRAMS * DAYS * WEEKS * EGGS;
        footprint += entry.getPotatoes().doubleValue() / GRAMS * DAYS * WEEKS * POTATOES;
        footprint += entry.getRice().doubleValue() / GRAMS * DAYS * WEEKS * RICE;
        footprint += entry.getNuts().doubleValue() / GRAMS * DAYS * WEEKS * NUTS;
        footprint += entry.getBeans().doubleValue() / GRAMS * DAYS * WEEKS * BEANS;
        footprint += entry.getTofu().doubleValue() / GRAMS * DAYS * WEEKS * TOFU;
        footprint += entry.getVegetables().doubleValue() / GRAMS * DAYS * WEEKS * VEGETABLES;
        footprint += entry.getMilk().doubleValue() / GRAMS * DAYS * WEEKS * MILK;
        footprint += entry.getFruit().doubleValue() / GRAMS * DAYS * WEEKS * FRUIT;
        return new ResponseEntity<>(footprint, HttpStatus.OK);
    }

    private FoodEntry getRecent(String username) {
        String sql = "SELECT * FROM dining_footprint df WHERE df.username = ?";
        RowMapper<FoodEntry> rowMapper = new BeanPropertyRowMapper<>(FoodEntry.class);		
        List<FoodEntry> entries = this.jdbcTemplate.query(sql, rowMapper, username);
        return entries.get(entries.size() - 1);
    }
}