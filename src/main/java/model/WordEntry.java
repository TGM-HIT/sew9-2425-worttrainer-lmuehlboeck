package model;

import java.net.MalformedURLException;
import java.net.URL;

public class WordEntry {
    private String word;
    private String url;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        if(word == null) throw new IllegalArgumentException();
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if(url == null) throw new IllegalArgumentException();
        try {
            new URL(url);
        } catch (MalformedURLException exc) {
            throw new IllegalArgumentException();
        }
        this.url = url;
    }
}
