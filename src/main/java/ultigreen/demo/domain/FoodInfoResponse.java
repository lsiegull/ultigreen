package ultigreen.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FoodInfoResponse {

    @JsonProperty("fooditems")
    private List<Food> foodItems; 
 
    public List<Food> getFoodItems() {
        return foodItems;
    }
 }