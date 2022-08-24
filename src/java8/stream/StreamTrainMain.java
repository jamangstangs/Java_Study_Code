package java8.stream;

import java8.stream.domain.Trader;
import java8.stream.domain.Transaction;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StreamTrainMain {

    public static void main(String[] args) {
        Trader a = new Trader("a", "seoul");
        Trader b = new Trader("b", "usa");
        Trader c = new Trader("c", "russia");
        Trader d = new Trader("d", "usa");
        Trader e = new Trader("e", "usa");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(e, 2011, 300),
                new Transaction(a, 2012, 1000),
                new Transaction(b, 2011, 400),
                new Transaction(c, 2012, 710),
                new Transaction(d, 2012, 700),
                new Transaction(e, 2012, 950)
                );

        // 2011년에 일어난 Transaction 모두 찾아 오름차순 정리
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        // 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        Set<String> cities1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        // usa 거주하는 거래자를 모두 찾아 이름순으로 정렬하시오
        List<Trader> tradersInUsa = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("usa"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        // 모든 거래자의 이름을 알파벳 순으로 정렬하시오
        String tradersName = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        // 서울 거주자가 있는가?
        boolean seoulTraderExists = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("seoul"));

        // usa 거주하는 거래자의 모든 트랜잭션 값을 출력하시오
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("usa"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 전체 트랜잭션 중 최댓값
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        // 전체 트랜잭션 중 최솟값
        Optional<Integer> minValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
    }
}
