package ultigreen.demo.services;

import org.springframework.stereotype.Service;
import ultigreen.demo.domain.FoodInfo;
import ultigreen.demo.domain.Food;

@Service
public class FoodService {

    private static final int DAYS_IN_WEEK = 7;
    private static final int WEEKS_IN_YR = 52;

    public double createService(Food[] foodItems) {
        double totalDailyCarbonFootprint = 0;
        for (Food foodItem : foodItems) {
            String name = foodItem.getName().toUpperCase();
            FoodInfo info = FoodInfo.valueOf(name);
            if (info != null) {
                totalDailyCarbonFootprint += info.calculateCarbonFootprint(foodItem.getServings());
            }
        }
        return totalDailyCarbonFootprint * DAYS_IN_WEEK * WEEKS_IN_YR;
    }
}