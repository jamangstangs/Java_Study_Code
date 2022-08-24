package java8.stream;

import java8.stream.domain.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamMapMain {

    public static void main(String[] args) {

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("apple", true, 500, Dish.Type.OTHER),
                new Dish("banana", false, 200, Dish.Type.OTHER),
                new Dish("pork", true, 900, Dish.Type.MEAT));

        List<String> dishNames = specialMenu.stream()
                .map(Dish::getName)
                .collect(toList());

        List<String> words = Arrays.asList("Modern", "Java", "in", "action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        List<Integer> dishNamesLength = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        // 잘못된 예제 1
        List<String> wordsList = Arrays.asList("sadfdjksan","qweiognbjisdfj", "fnadsuibqwui");
        List<String[]> eachWord = wordsList.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        String[] arrayOfWords = {"GoodBye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        // 잘못된 예제 2
        List<Stream<String>> collect = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        // 잘된 예제
        List<String> uniqueCharacters =
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());


        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);
        List<int[]> pairs = nums1.stream()
                .flatMap(i -> nums2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i,j})
                )
                .collect(toList());

    }
}
