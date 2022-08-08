package java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteArroundPatternMain {

    public static void main(String[] args) throws IOException {

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

//    private static String processFile() throws IOException {
//        try (BufferedReader br =
//                     new BufferedReader(new FileReader("data.txt"))) {
//            return br.readLine();
//        }
//    }
}
