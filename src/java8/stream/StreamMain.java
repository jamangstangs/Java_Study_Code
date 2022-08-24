package java8.stream;

import java8.stream.domain.Dish;
import java8.stream.domain.Dish.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java8.stream.domain.Dish.Type.*;

public class StreamMain {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", false, 120, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH)
                );

        // 파이프라인 연산 만들기
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories()>300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);

    }
}
