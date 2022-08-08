package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {

        // 비어있지 않은 String만 추출한다.
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> listOfString = new ArrayList<>();
        listOfString.add("asdfsafs");
        listOfString.add("");
        listOfString.add("asdfs");
        listOfString.add("asafs");
        listOfString.add("");
        List<String> nonEmptyStringList = filter(listOfString, nonEmptyStringPredicate);

        System.out.println("nonEmptyStringList = " + nonEmptyStringList);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T t : results) {
            if (predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

}
