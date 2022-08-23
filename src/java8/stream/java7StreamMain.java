package java8.stream;

import java.util.*;

public class java7StreamMain {
    public static void main(String[] args) {

        List<Dish> lowCaloricDishes = new ArrayList<>();
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish(100,"fish"));
        menu.add(new Dish(200,"meat"));
        menu.add(new Dish(300,"fruit"));
        menu.add(new Dish(400,"graph"));
        menu.add(new Dish(500,"apple"));
        menu.add(new Dish(600,"banana"));
        // for로 필터링
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        // 익명 클래스로 요리 정렬
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        // 정렬된 리스트를 처리하면서 요리 이름 선택
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
    }
}
