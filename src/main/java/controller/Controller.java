package controller;

import model.*;
import view.*;

public class Controller {
    private WordTrainerPersister persister;
    private WordTrainer trainer;
    private View view;

    public Controller() {
        this(new WordTrainerJsonPersister());
    }

    public Controller(WordTrainerPersister persister) {
        if(persister == null) throw new IllegalArgumentException();
        this.persister = persister;
    }

    public void check(String input) {

    }

    public WordEntry selectNewEntry() {

    }

    public void reset() {

    }

    public void save() {

    }
}
