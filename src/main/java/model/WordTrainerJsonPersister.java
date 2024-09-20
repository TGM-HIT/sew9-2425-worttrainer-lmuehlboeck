package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a word trainer persister that saves and loads a word trainer to and from a JSON file.
 * @author Leo Mühlböck
 * @version 2024-09-20
 */
public class WordTrainerJsonPersister implements WordTrainerPersister {
    private final String path;
    private final Gson gson;

    /**
     * Creates a new word trainer persister with the default path.
     */
    public WordTrainerJsonPersister() {
        this("./word_trainer.json");
    }

    /**
     * Creates a new word trainer persister with the given path.
     * @param path the path
     */
    public WordTrainerJsonPersister(String path) {
        if(path == null) throw new IllegalArgumentException();
        this.path = path;
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        this.gson = builder.create();
    }

    /**
     * Saves the given word trainer to the JSON file.
     * @param trainer the word trainer
     */
    @Override
    public void save(WordTrainer trainer) {
        try {
            gson.toJson(trainer, new FileWriter(this.path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the word trainer from the JSON file.
     * @return the word trainer
     */
    @Override
    public WordTrainer load() {
        return gson.fromJson(path, WordTrainer.class);
    }
}
