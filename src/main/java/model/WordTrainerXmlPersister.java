package model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Represents a word trainer persister that saves and loads a word trainer to and from an XML file.
 * @author Benjamin Edlinger
 * @version 2024-09-30
 */
public class WordTrainerXmlPersister implements WordTrainerPersister {
    private final String path;

    /**
     * Creates a new word trainer persister with the default path.
     */
    public WordTrainerXmlPersister() {
        this("./word_trainer.xml");
    }

    /**
     * Creates a new word trainer persister with the given path.
     * @param path the path
     */
    public WordTrainerXmlPersister(String path) {
        if (path == null) throw new IllegalArgumentException();
        this.path = path;
    }

    /**
     * Saves the given word trainer to the XML file.
     * @param trainer the word trainer
     */
    @Override
    public void save(WordTrainer trainer) {
        if (trainer == null) throw new IllegalArgumentException();
        try {
            JAXBContext context = JAXBContext.newInstance(WordTrainer.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(trainer, new File(path));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the word trainer from the XML file.
     * @return the word trainer
     */
    @Override
    public WordTrainer load() {
        try {
            return (WordTrainer) JAXBContext.newInstance(WordTrainer.class).createUnmarshaller().unmarshal(new File(path));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
