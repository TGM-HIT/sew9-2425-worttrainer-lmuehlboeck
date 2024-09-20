package model;

public interface WordTrainerPersister {
    void save(WordTrainer trainer);
    WordTrainer load();
}
