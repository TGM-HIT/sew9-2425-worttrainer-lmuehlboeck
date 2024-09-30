package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

/**
 * Represents a word entry.
 * @author Leo Mühlböck, Benjamin Edlinger
 * @version 2024-09-30
 */
@XmlRootElement(name = "entry")
public class WordEntry {
    private String word;
    private String url;

    /**
     * Creates a new word entry with the default word and URL.
     */
    public WordEntry() {
        setWord("Hund");
        setUrl("https://upload.wikimedia.org/wikipedia/commons/4/42/Harzer_Fuchs_H%C3%BCndin_2.jpg");
    }

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
    @XmlElement(name = "word")
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
    @XmlElement(name = "url")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordEntry wordEntry = (WordEntry) o;
        return Objects.equals(word, wordEntry.word) && Objects.equals(url, wordEntry.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, url);
    }
}
