package ultigreen.demo.services;

import org.springframework.stereotype.Service;
import ultigreen.demo.domain.FoodInfo;
import ultigreen.demo.domain.FoodEntry;
import ultigreen.demo.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Service
public class FoodService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final int DAYS_IN_WEEK = 7;
    private static final int WEEKS_IN_YR = 52;

    public void insertIntoDatabase(String username, List<Food> items) {
        jdbcTemplate.batchUpdate(makeInsertSql(items), splitUpInsertItems(username, items));
    }

    public void updateDatabase(String username, List<Food> items) {
        jdbcTemplate.batchUpdate(makeUpdateSql(items), splitUpUpdateItems(username, items));
    }

    public List<FoodEntry> getAllFromDatabase(String username) {
        RowMapper<FoodEntry> rowMapper = new BeanPropertyRowMapper<>(FoodEntry.class);		
        return this.jdbcTemplate.query("SELECT * FROM dining_footprint df WHERE df.username = ?", rowMapper, username);
    }

    public double calculateCarbonFootprint() {
        // Need to retreive items from db
        // double totalDailyCarbonFootprint = 0;
        // for (Food item : items) {
        //     String name = item.getName().toUpperCase();
        //     FoodInfo info = FoodInfo.valueOf(name);
        //     if (info != null) {
        //         totalDailyCarbonFootprint += info.calculateCarbonFootprint(item.getServings());
        //     }
        // }
        // return totalDailyCarbonFootprint * DAYS_IN_WEEK * WEEKS_IN_YR;
        return 0;
    }

    private String makeUpdateSql(List<Food> items) {
        String sql = "UPDATE dining_footprint SET ";
        for (int i = 0; i < items.size() - 1; i++) {
            sql += items.get(i).getName() + "=?, ";
        }
        sql += items.get(items.size() - 1).getName() + "=? WHERE username=?";
        return sql;
    }

    private String makeInsertSql(List<Food> items) {
        String sql = "INSERT INTO dining_footprint(username, ";
        for (int i = 0; i < items.size() - 1; i++) {
            sql += items.get(i).getName() + ", ";
        }
        sql += items.get(items.size() - 1).getName() + ") values (?, ";
        for (int i = 0; i < items.size() - 1; i++) {
            sql += "?, ";
        }
        sql += "?)";
        return sql;
    }

    private List<Object[]> splitUpUpdateItems(String username, List<Food> items) {
        String list = "";
        for (int i = 0; i < items.size() - 1; i++) {
            list += items.get(i).getServings() + " ";
        }
        list += items.get(items.size() - 1).getServings() + " " + username;
        System.out.println(list);
        return Arrays.asList(list).stream().map(str -> str.split(" ")).collect(Collectors.toList());
    }

    private List<Object[]> splitUpInsertItems(String username, List<Food> items) {
        String list = username + " ";
        for (int i = 0; i < items.size() - 1; i++) {
            list += items.get(i).getServings() + " ";
        }
        list += items.get(items.size() - 1).getServings();
        System.out.println(list);
        return Arrays.asList(list).stream().map(str -> str.split(" ")).collect(Collectors.toList());
    }
}