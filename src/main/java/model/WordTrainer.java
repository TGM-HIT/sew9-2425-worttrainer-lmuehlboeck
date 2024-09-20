package model;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a word trainer.
 * @author Leo MÜhlböck
 * @version 2024-09-18
 */
public class WordTrainer {
    private List<WordEntry> entries;
    private int selected;
    private int numAsked;
    private int numRight;

    /**
     * Default entries for the word trainer.
     */
    public static final List<WordEntry> defaultEntries = Arrays.asList(
            new WordEntry("Elefant", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Elephant_near_ndutu.jpg/640px-Elephant_near_ndutu.jpg")
    );

    /**
     * Creates a new word trainer with the default entries.
     */
    public WordTrainer() {
        this(defaultEntries, -1, 0, 0);
    }

    /**
     * Creates a new word trainer with the given entries.
     * @param entries the entries
     * @param selected the selected entry
     * @param numAsked the number of asked entries
     * @param numRight the number of right answers
     */
    public WordTrainer(List<WordEntry> entries, int selected, int numAsked, int numRight) {
        setEntries(entries);
        selectEntry(selected);
        setNumAsked(numAsked);
        setNumRight(numRight);
    }

    /**
     * Returns the entries.
     * @return the entries
     */
    public List<WordEntry> getEntries() {
        return entries;
    }

    /**
     * Sets the entries.
     * @param entries the entries
     */
    public void setEntries(List<WordEntry> entries) {
        if(entries == null) throw new IllegalArgumentException();
        this.entries = entries;
    }

    /**
     * Returns the number of asked entries.
     * @return the number of asked entries
     */
    public int getNumAsked() {
        return numAsked;
    }

    /**
     * Sets the number of asked entries.
     * @param numAsked the number of asked entries
     */
    public void setNumAsked(int numAsked) {
        if(numAsked < 0) throw  new IllegalArgumentException();
        this.numAsked = numAsked;
    }

    /**
     * Returns the number of right answers.
     * @return the number of right answers
     */
    public int getNumRight() {
        return numRight;
    }

    /**
     * Sets the number of right answers.
     * @param numRight the number of right answers
     */
    public void setNumRight(int numRight) {
        if(numRight < 0) throw new IllegalArgumentException();
        this.numRight = numRight;
    }

    /**
     * Returns the selected entry.
     * @return the selected entry
     */
    public WordEntry selectRandomEntry() {
        this.selected = (int)(Math.random() * entries.size());
        return getSelectedEntry();
    }

    /**
     * Returns the selected entry.
     * @param index the index of the entry
     * @return the selected entry
     */
    public WordEntry selectEntry(int index) {
        if(index >= entries.size()) throw new IllegalArgumentException();
        this.selected = index;
        return getSelectedEntry();
    }

    /**
     * Returns the selected entry.
     * @return the selected entry
     */
    public WordEntry getSelectedEntry() {
        if(this.selected < 0) return null;
        return this.entries.get(this.selected);
    }

    /**
     * Checks if the given input is correct.
     * @param input the input
     * @return true if the input is correct, false otherwise
     */
    public boolean check(String input) {
        boolean correct = getSelectedEntry().getWord().equals(input);
        if(correct) numRight++;
        numAsked++;
        return correct;
    }
}
