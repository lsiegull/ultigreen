package ultigreen.demo.domain;

public enum FoodInfo {
    LAMB(85, 39.2), BEEF(85, 27.0), CHEESE(56, 13.5), PORK(85, 12.1),
    TURKEY(85, 10.9), CHICKEN(85, 6.9), TUNA(85, 6.1), EGGS(50, 4.8),
    POTATOES(64, 2.9), RICE(64, 2.7), NUTS(43, 2.3), BEANS(32, 2.0),
    TOFU(32, 2.0), VEGETABLES(75, 2.0), MILK(230, 1.9), FRUIT(175, 1.1);
    
    private final int gramsPerServing;
    private final double poundsCarbonPerKg;

    private static final int GRAMS_PER_KG = 1000;

    FoodInfo(int gramsPerServing, double poundsCarbonPerKg) {
        this.gramsPerServing = gramsPerServing;
        this.poundsCarbonPerKg = poundsCarbonPerKg;
    }

    public double calculateCarbonFootprint(double numServingsPerWeek) {
        double grams = numServingsPerWeek * gramsPerServing;
        double kilograms = grams / GRAMS_PER_KG;
        double pounds = kilograms * poundsCarbonPerKg;
        return pounds;
    }
}