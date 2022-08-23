package java8.stream;

public class Dish {
    private int calories;
    private String name;

    public String getName() {
        return name;
    }

    public Dish(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public Dish(int calories) {
        this.calories = calories;
    }



    public int getCalories() {
        return calories;
    }
}
