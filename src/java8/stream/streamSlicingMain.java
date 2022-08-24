package java8.stream;

import java8.stream.domain.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class streamSlicingMain {

    public static void main(String[] args) {

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("apple", true, 500, Dish.Type.OTHER),
                new Dish("banana", false, 200, Dish.Type.OTHER),
                new Dish("pork", true, 900, Dish.Type.MEAT));

        // 여기서 300 칼로리 이하 요리를 선택하자.
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 300)
                .collect(toList());

        // takeWhile 활용하여 효율적인 슬라이싱
        List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 300)
                .collect(toList());

    }
}
