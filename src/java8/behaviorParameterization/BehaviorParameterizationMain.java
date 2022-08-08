package java8.behaviorParameterization;

import java8.behaviorParameterization.predicate.AppleFormatter;
import java8.behaviorParameterization.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class BehaviorParameterizationMain {

    public static void main(String[] args) {


    }

    // Anonymous Class 사용 -> 동작 파라미터화

    // Interface 사용 -> 동작 파라미터화
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            System.out.println(appleFormatter.accept(apple));
        }
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (a.getColor().equals(color)) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : inventory) {
            if (a.getWeight() > weight) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    // predicate 전달
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
