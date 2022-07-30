package java8.methodReference;

import java.util.ArrayList;
import java.util.List;

import static java8.methodReference.Color.*;

public class MethodReferenceMain {

    public static void main(String[] args) {
        // 사과 리스트 생성
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(RED,100));
        inventory.add(new Apple(GREEN,100));
        inventory.add(new Apple(PURPLE,200));
        inventory.add(new Apple(RED,100));
        inventory.add(new Apple(GREEN,100));
        inventory.add(new Apple(RED,100));

        System.out.println(filterGreenApples(inventory));
        System.out.println(filterHeavyApples(inventory));

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        // 150 이상 필터링한다고 하자.
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > 150 ) {
                result.add(apple);
            }
        }
        return result;
    }
}
