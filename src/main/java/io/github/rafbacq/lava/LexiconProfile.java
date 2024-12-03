package io.github.rafbacq.lava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.function.BiConsumer;

public class LexiconProfile {
	private boolean isCalculated;
	
    private FrequencyMap<String> lexicon;
    private String word;
    private int wordCount = 0;
    private int phraseCount = 0;
    private int lexicalSize = 0;
    private double avg = 0;

    public LexiconProfile(FrequencyMap<String> lexicon) {
        this.lexicon = lexicon;
		this.lexicon.remove(""); // empty string was polluting some things
    }

    public LexiconProfile(File sample) throws FileNotFoundException, IOException {
        if(sample == null) throw new NullPointerException("Samples cannot be null.");

        this.lexicon = FrequencyReader.countWordFrequency(sample);    
		this.lexicon.remove("");  
    }
    
    public static double compare(LexiconProfile l1, LexiconProfile l2) {
    	final double wordWeight = 0.6;
		final double lengthWeight = 0.05;
    	
    	var bic = new BiConsumer<String, Long>() {
    		double comp = 0.0;
    		long normalizer = 0L;
//    		long max = 0L; // can't use lambda sadly
			@Override
			public void accept(String key, Long freq) {
//				max += freq;
				long f2 = l2.lexicon.get(key);
				int numWords = key.split("\\s+").length + 1;
				normalizer += (freq + f2);
				double max = Math.max(freq, f2);
				double min = Math.min(freq, f2);
				comp += (max - min) * (Math.pow(wordWeight, numWords));
			}
    	};
    	
    	l1.lexicon.forEach(bic);
    	
    	double a = bic.comp / bic.normalizer;
    	
    	bic.comp = 0.0;
    	bic.normalizer = 0L;
//    	bic.max = 0L;
    	
    	l2.lexicon.forEach(bic);
    	
    	double b = bic.comp / bic.normalizer;
    	
    	return 1.0 - ((a + b) * 0.5);
    }


//    public LexiconProfile calculate() {
//    	if(isCalculated) return this;
//    	
//    	BiConsumer<String,Long> action = (word, l) -> {
//    		if(word.contains(" ")) {
//    			
//    		}
//    		count += word.length() * l;
//    		lexicalSize += l;
////    		System.out.println("key " + key);
////    		System.out.println("long " + l);
//    	};
//    	
//        lexicon.forEach(action);
////    	System.out.println(count);
////    	System.out.println(lexicon.size());
//    	
//        this.avg = ((double)count/lexicon.size());
//		return this;
//    }
//    
//    @Override
//    public String toString() {
//    	return "Lexical Elemants: " + lexicalSize + "\nAverage word length: " + avg;
//    }
}
