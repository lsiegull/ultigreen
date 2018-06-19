public class Food {

    private String name;
    private double servings;

    public Food(String name, double servings) {
        this.name = name;
        this.servings = servings;
    }

    public String getName() {
        return name;
    }

    public double getServings() {
        return servings;
    }
}