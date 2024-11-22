package io.github.rafbacq.lava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class LexiconProfile {
    private FrequencyMap<String> lexicon;

    public LexiconProfile(FrequencyMap<String> lexicon) {
        super();
        this.lexicon = lexicon;
    }

    public LexiconProfile(File... samples) throws FileNotFoundException, IOException {
        super();
        if(samples == null) throw new NullPointerException("Samples cannot be null.");
        if(samples.length == 0) throw new IllegalArgumentException("Samples must have at least one element.");

        this.lexicon = FrequencyReader.countWordFrequency(samples[0]);
        for (int i = 1; i < samples.length; i++) {
            File file = samples[i];
            FrequencyMap<String> map = FrequencyReader.countWordFrequency(file);
            map.forEach((key, value) -> {
                lexicon.merge(key, value, Long::sum);
            });
        }
    }

    /**
     * Compares this lexicon profile with another.
     * 
     * @param profile The profile to compare with.
     * @return A value from {@code [0, 1]} where values closer to 1
     * indicate a greater similarity, while values closer to 0 indicate 
     * less similarity.
     */
    public double compareTo(LexiconProfile profile) {
        Objects.requireNonNull(profile);
        // TODO compare lexicon profiles
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
