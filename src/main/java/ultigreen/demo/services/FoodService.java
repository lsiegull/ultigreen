package ultigreen.demo.services;

import org.springframework.stereotype.Service;
import ultigreen.demo.domain.FoodInfo;
import ultigreen.demo.domain.Food;

@Service
public class FoodService {

    public double createService(Food[] foodItems) {
        double totalWeeklyCarbonFootprint = 0;
        for (Food foodItem : foodItems) {
            String name = foodItem.getName().toUpperCase();
            FoodInfo info = FoodInfo.valueOf(name);
            if (info != null) {
                totalWeeklyCarbonFootprint += info.calculateCarbonFootprint(foodItem.getServings());
            }
        }
        return totalWeeklyCarbonFootprint;
    }
}