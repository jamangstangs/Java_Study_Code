package java8.stream;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class java8StreamMain {

    public static void main(String[] args) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish(100,"fish"));
        menu.add(new Dish(200,"meat"));
        menu.add(new Dish(300,"fruit"));
        menu.add(new Dish(400,"graph"));
        menu.add(new Dish(500,"apple"));
        menu.add(new Dish(600,"banana"));

        List<String> lowCaloricDishesName =
                menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());

        List<String> names = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
    }
}
