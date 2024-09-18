package model;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Represents a word entry.
 * @author Leo MÜhlböck
 * @version 2024-09-18
 */
public class WordEntry {
    private String word;
    private String url;

    /**
     * Creates a new word entry with the given word and URL.
     * @param word the word
     * @param url the URL
     */
    public WordEntry(String word, String url) {
        setWord(word);
        setUrl(url);
    }

    /**
     * Returns the word.
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word.
     * @param word the word
     */
    public void setWord(String word) {
        if(word == null || word.isEmpty()) throw new IllegalArgumentException();
        this.word = word;
    }

    /**
     * Returns the URL.
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL.
     * @param url the URL
     */
    public void setUrl(String url) {
        if(url == null) throw new IllegalArgumentException();
        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException exc) {
            throw new IllegalArgumentException();
        }
        this.url = url;
    }
}
