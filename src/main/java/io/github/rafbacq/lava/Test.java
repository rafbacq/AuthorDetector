package io.github.rafbacq.lava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File mystery1 = new File("files\\mystery1.txt");
        // Map<String, Long> wordFrequencyMap = FrequencyReader.countOneWordFrequency(mystery1);
        // System.out.println(wordFrequencyMap + "\n");
        // System.out.println("Two word groups: " + FrequencyReader.countTwoWordFrequency(mystery1) + "\n");
        // System.out.println("Three word groups: " + FrequencyReader.countThreeWordFrequency(mystery1) + "\n");

        FrequencyMap<String> wordFrequencyMap = FrequencyReader.countWordFrequency(mystery1);
        System.out.println(wordFrequencyMap);
    }
}
