package io.github.rafbacq.lava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File mystery1 = new File("files/mystery1.txt");
        File mystery2 = new File("files/mystery2.txt");
        
        LexiconProfile andrew = new LexiconProfile(new File("files/trainAndrew.txt"));
        LexiconProfile fls = new LexiconProfile(new File("files/trainFALSE.txt"));
        LexiconProfile jennifer = new LexiconProfile(new File("files/trainJennifer.txt"));
        LexiconProfile john = new LexiconProfile(new File("files/trainJohn.txt"));
        LexiconProfile jon = new LexiconProfile(new File("files/trainJon.txt"));
        LexiconProfile kyle = new LexiconProfile(new File("files/trainKyle.txt"));

        System.out.println(LexiconProfile.compare(jon, jon));
        
        // Map<String, Long> wordFrequencyMap = FrequencyReader.countOneWordFrequency(mystery1);
        // System.out.println(wordFrequencyMap + "\n");
        // System.out.println("Two word groups: " + FrequencyReader.countTwoWordFrequency(mystery1) + "\n");
        // System.out.println("Three word groups: " + FrequencyReader.countThreeWordFrequency(mystery1) + "\n");

        Map<LexiconProfile, String> profiles = Map.of(andrew, "Andrew", fls, "FALSE", jennifer, "Jennifer", john, "John", jon, "Jon", kyle, "Kyle");

        for(int i = 1; i <= 6; i++) {
            LexiconProfile mystery = new LexiconProfile(new File("files/mystery" + i + ".txt"));
            getBest(profiles, mystery);
        }

        // LexiconProfile l1 = new LexiconProfile(mystery1);
        // LexiconProfile l2 = new LexiconProfile(mystery2);
        // System.out.println(LexiconProfile.compare(l1, l2));
        
    }

    private static void getBest(Map<LexiconProfile, String> profiles, LexiconProfile mystery) {
        double bestComp = Double.NEGATIVE_INFINITY;
        Entry<LexiconProfile, String> best = null;
        
        for (Entry<LexiconProfile, String> entry : profiles.entrySet()) {
            double comp = LexiconProfile.compare(entry.getKey(), mystery);
            // System.out.println(comp + " " + bestComp);
            if(bestComp < comp) {
                bestComp = comp;
                best = entry;
            }
            System.out.println("Current match: " + entry.getValue() + " with " + comp);
        }
        System.out.println("Best match: " + best.getValue() + " with " + bestComp);
    }
}
