package files.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyReader {
    public static FrequencyMap<String> countWordFrequency(Reader reader) {
        BufferedReader buff = new BufferedReader(reader);
        Stream<String> stream = buff.lines();
        Map<String, Long> map = stream
            .flatMap(line -> {
                return Arrays.stream(line.replaceAll("[^A-Za-z\\-_]+", " ").split("\\s+"));
            }) // split by spaces
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new FrequencyMap<>(map);
    }

    public static FrequencyMap<String> countWordFrequency(File file) throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader(file)) {
            return countWordFrequency(fr);   
        }
    }
}
