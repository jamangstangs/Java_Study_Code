package java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    // (BufferedReader) -> String
    String process(BufferedReader b) throws IOException;
}
