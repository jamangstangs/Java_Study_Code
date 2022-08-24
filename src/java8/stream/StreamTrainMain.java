package java8.stream;

import java8.stream.domain.Trader;
import java8.stream.domain.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StreamTrainMain {

    public static void main(String[] args) {
        Trader a = new Trader("a", "seoul");
        Trader b = new Trader("b", "busan");
        Trader c = new Trader("c", "russia");
        Trader d = new Trader("d", "usa");
        Trader e = new Trader("e", "japan");

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

    }
}
