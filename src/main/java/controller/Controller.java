package controller;

import model.*;
import view.*;

/**
 * Controller class for the WordTrainer application.
 * @author Leo Mühlböck
 * @version 2024-09-21
 */
public class Controller {
    private WordTrainerPersister persister;
    private WordTrainer trainer;
    private View view;

    /**
     * Creates a new Controller object.
     */
    public Controller() {
        this(new WordTrainerJsonPersister());
    }

    /**
     * Creates a new Controller object.
     * @param persister the persister to use
     */
    public Controller(WordTrainerPersister persister) {
        if(persister == null) throw new IllegalArgumentException();
        this.persister = persister;
        trainer = persister.load();
        if(trainer == null) trainer = new WordTrainer();
        view = new View(this);
        selectNewEntry();
    }

    /**
     * Sets the view.
     * @param view the view to set
     */
    public void check(String input) {
        if(input.isEmpty()) return;
        trainer.check(input);
        selectNewEntry();
        view.setNum(trainer.getNumAsked(), trainer.getNumRight());
    }

    /**
     * Sets the view.
     * @param view the view to set
     */
    public void selectNewEntry() {
        WordEntry entry = trainer.selectRandomEntry();
        view.setNum(trainer.getNumAsked(), trainer.getNumRight());
        view.setImg(entry.getUrl());
        view.setInput("");
    }

    /**
     * Sets the view.
     * @param view the view to set
     */
    public void save() {
        persister.save(trainer);
    }
}
