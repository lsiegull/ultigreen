package ultigreen.demo.services;

import org.springframework.stereotype.Service;
import ultigreen.demo.domain.FoodInfo;
import ultigreen.demo.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class FoodService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final int DAYS_IN_WEEK = 7;
    private static final int WEEKS_IN_YR = 52;

    public void insertIntoDatabase(Food[] items) {
        String list = "";
        for (int i = 0; i < items.length - 1; i++) {
            list += items[i].getServings();
        }
        list += items[items.length - 1];
        List<Object[]> splitUpFood = Arrays.asList(list).stream().map(str -> str.split(" ")).collect(Collectors.toList());
        String sql = "INSERT INTO food(";
        for (int i = 0; i < items.length - 1; i++) {
            sql += items[i].getName() + ", ";
        }
        sql += items[items.length - 1] + ") values (";
        for (int i = 0; i < items.length - 1; i++) {
            sql += "?, ";
        }
        sql += "?)";
        jdbcTemplate.batchUpdate(sql, splitUpFood);
    }

    public double calculateCarbonFootprint() {
        // Need to retreive items from db
        double totalDailyCarbonFootprint = 0;
        for (Food item : items) {
            String name = item.getName().toUpperCase();
            FoodInfo info = FoodInfo.valueOf(name);
            if (info != null) {
                totalDailyCarbonFootprint += info.calculateCarbonFootprint(item.getServings());
            }
        }
        return totalDailyCarbonFootprint * DAYS_IN_WEEK * WEEKS_IN_YR;
    }
}