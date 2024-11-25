package io.github.rafbacq.lava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File mystery1 = new File("files/mystery1.txt");
        File mystery2 = new File("files/mystery2.txt");
        
        LexiconProfile andrew = new LexiconProfile(new File("files/trainAndrew.txt"));
        
        // Map<String, Long> wordFrequencyMap = FrequencyReader.countOneWordFrequency(mystery1);
        // System.out.println(wordFrequencyMap + "\n");
        // System.out.println("Two word groups: " + FrequencyReader.countTwoWordFrequency(mystery1) + "\n");
        // System.out.println("Three word groups: " + FrequencyReader.countThreeWordFrequency(mystery1) + "\n");

        FrequencyMap<String> wordFrequencyMap = FrequencyReader.countWordFrequency(mystery1);
        LexiconProfile l1 = new LexiconProfile(mystery1);
        LexiconProfile l2 = new LexiconProfile(mystery2);
        System.out.println(LexiconProfile.compare(l1, l2));
        
    }
}
