package io.github.rafbacq.lava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyReader {
    public static FrequencyMap<String> countWordFrequency(File file) throws FileNotFoundException, IOException {
        FrequencyMap<String> ret = countOneWordFrequency(file);
        ret.putAll(countTwoWordFrequency(file));
        ret.putAll(countThreeWordFrequency(file));
        return ret;
    }

    public static FrequencyMap<String> countOneWordFrequency(Reader reader) {
        BufferedReader buff = new BufferedReader(reader);
        Stream<String> stream = buff.lines();
        Map<String, Long> map = stream
            .flatMap(line -> {
                return Arrays.stream(line.replaceAll("[^A-Za-z\\-_]+", " ").split("\\s+"));
            }) // split by spaces
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new FrequencyMap<>(map);
    }

    public static FrequencyMap<String> countOneWordFrequency(File file) throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader(file)) {
            return countOneWordFrequency(fr);   
        }
    }

    public static FrequencyMap<String> countTwoWordFrequency(Reader reader) {
        BufferedReader buff = new BufferedReader(reader);
        Stream<String> stream = buff.lines();
        
        Map<String, Long> map = stream
            .flatMap(line -> {
                // Split line into words, removing non-alphabetic characters
                String[] words = line.replaceAll("[^A-Za-z\\-_]+", " ").split("\\s+");
                
                // Create two-word groups
                List<String> twoWordGroups = new ArrayList<>();
                for (int i = 0; i < words.length - 1; i++) {
                    twoWordGroups.add(words[i] + " " + words[i+1]);
                }
                
                return twoWordGroups.stream();
            }) // split into two-word groups
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        return new FrequencyMap<>(map);
    }
    
    public static FrequencyMap<String> countTwoWordFrequency(File file) throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader(file)) {
            return countTwoWordFrequency(fr);   
        }
    }

    public static FrequencyMap<String> countThreeWordFrequency(Reader reader) {
            BufferedReader buff = new BufferedReader(reader);
            Stream<String> stream = buff.lines();
            
            Map<String, Long> map = stream
                .flatMap(line -> {
                    // Split line into words, removing non-alphabetic characters
                    String[] words = line.replaceAll("[^A-Za-z\\-_]+", " ").split("\\s+");
                    
                    // Create three-word groups
                    List<String> threeWordGroups = new ArrayList<>();
                    for (int i = 0; i < words.length - 2; i++) {
                        threeWordGroups.add(words[i] + " " + words[i+1] + " " + words[i+2]);
                    }
                    
                    return threeWordGroups.stream();
                }) // split into three-word groups
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            
            return new FrequencyMap<>(map);
        }
        
        public static FrequencyMap<String> countThreeWordFrequency(File file) throws FileNotFoundException, IOException {
            try (FileReader fr = new FileReader(file)) {
                return countThreeWordFrequency(fr);   
            }
        }
}
