package model;

/**
 * Represents a word trainer persister.
 * @author Leo Mühlböck
 * @version 2024-09-20
 */
public interface WordTrainerPersister {
    /**
     * Saves the given word trainer.
     * @param trainer the word trainer
     */
    void save(WordTrainer trainer);

    /**
     * Loads the word trainer.
     * @return the word trainer
     */
    WordTrainer load();
}
