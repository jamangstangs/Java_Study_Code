package java8.methodReference;

import java.util.ArrayList;
import java.util.List;

import static java8.methodReference.Color.*;

public class MethodReferenceMain {

    public static void main(String[] args) {
        // 사과 리스트 생성
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(RED));
        inventory.add(new Apple(GREEN));
        inventory.add(new Apple(PURPLE));
        inventory.add(new Apple(RED));
        inventory.add(new Apple(GREEN));
        inventory.add(new Apple(RED));

        System.out.println(filterGreenApples(inventory));
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
}
