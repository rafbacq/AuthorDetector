package io.github.rafbacq.lava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, Long> wordFrequencyMap = FrequencyReader.countWordFrequency(new File("files\\mystery1.txt"));
        System.out.println(FrequencyReader.countWordFrequency(new File("files\\mystery1.txt")) + "\n");
        System.out.println("Two word groups: " + FrequencyReader.countTwoWordFrequency(new File("files\\mystery1.txt")) + "\n");
        System.out.println("Three word groups: " + FrequencyReader.countThreeWordFrequency(new File("files\\mystery1.txt")) + "\n");
    }
}
