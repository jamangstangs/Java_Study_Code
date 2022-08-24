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

        // takeWhile 활용하여 참인 지점까지만 take 슬라이싱
        List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 300)
                .collect(toList());
        // dropWhile을 활용하여 처음으로 거짓이 나오는 지점가지 drop한다.
        List<Dish> slicedMenu2
                = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 300)
                .collect(toList());

        // limit(n) 메서드 활용
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        // skip(n) 메서드 활용
        List<Dish> dishes1 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());

    }
}
