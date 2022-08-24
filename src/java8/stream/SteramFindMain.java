package java8.stream;

import java8.stream.domain.Dish;

import java.util.Arrays;
import java.util.List;

public class SteramFindMain {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("apple", true, 500, Dish.Type.OTHER),
                new Dish("banana", false, 200, Dish.Type.OTHER),
                new Dish("pork", true, 900, Dish.Type.MEAT));

        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("채식주의자 쌉가능");
        }

        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        boolean isHealthy1 = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
    }
}
