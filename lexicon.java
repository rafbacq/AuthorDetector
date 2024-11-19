import java.util.*;
import java.io.*;

public class lexicon {
    static Set <String> commonWords;
    public lexicon()
    {

    }
    public static void addWords() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("/Users/tristancarter/AuthorDetector/commonWords.txt"));
        commonWords= new HashSet();
        for(int i=0; i<3171; i++)
        {
            commonWords.add(br.readLine());
        }
        
    }
    public static double frequencyTranslator(Map<String, Integer> hm, int sentences)
    {

        int wordCount=0;
        int difficultWords=0;
        for(String s: hm.keySet())
        {

            
            if(!commonWords.contains(s))
            {
                difficultWords+=1;

            }
            wordCount+=hm.get(s);
        }
        return 0.1579*((difficultWords/wordCount)*100) + 0.0496*(wordCount/sentences);

    }
    public static void main(String [] args) throws IOException
    {
        addWords();
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Tiger", 6);
        hm.put("Lion", 9);
        hm.put("Camille", 1);
        hm.put("Computer", 8);
        hm.put("Heirograph", 3);
        System.out.println(frequencyTranslator(hm,10));

    }
}
