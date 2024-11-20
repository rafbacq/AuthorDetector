package files.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println(FrequencyReader.countWordFrequency(new File("files\\mystery1.txt")));
    }
}
