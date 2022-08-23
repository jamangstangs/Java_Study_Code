package java8.methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static java8.methodReference.Color.*;
import static java8.methodReference.Color.GREEN;
import static java8.methodReference.Color.PURPLE;

public class ConstructorReference {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Color> colors = Arrays.asList(GREEN, RED, PURPLE, GREEN);

        List<Apple> apples = map(weights, colors, Apple::new);
        System.out.println("apples = " + apples);
    }


    public static List<Apple> map(List<Integer> weights, List<Color> colors, BiFunction<Color, Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (int i = 0; i < weights.size(); i++) {
            result.add(f.apply(colors.get(i), weights.get(i)));
        }
        return result;
    }
}
