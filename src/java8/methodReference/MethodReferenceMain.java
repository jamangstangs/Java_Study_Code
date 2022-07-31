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

        System.out.println(filterApples(inventory, (Apple a)-> GREEN.equals(a.getColor())));
        System.out.println(filterApples(inventory, (Apple a) -> a.getWeight() > 150));
    }

    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    public interface Predicate<T> {
        boolean test(T t);
    }
//
    // 비교 함수들을 선언한다.
//
//    public static boolean isGreenApple(Apple apple) {
//        return GREEN.equals(apple.getColor());
//    }
//
//    public static boolean isHeabyApple(Apple apple) {
//        return apple.getWeight() > 150;
//    }

//
//
//    public static List<Apple> filterGreenApples(List<Apple> inventory) {
//        List<Apple> result = new ArrayList<>();
//
//        for (Apple apple : inventory) {
//            if (GREEN.equals(apple.getColor())) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
//
//    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
//        // 150 이상 필터링한다고 하자.
//        List<Apple> result = new ArrayList<>();
//
//        for (Apple apple : inventory) {
//            if (apple.getWeight() > 150 ) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
}
