import controller.Controller;
import model.WordTrainerJsonPersister;
import model.WordTrainerPersister;
import model.WordTrainerXmlPersister;

import javax.swing.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Map<String, WordTrainerPersister> persisters = Map.of("JSON", new WordTrainerJsonPersister(), "XML", new WordTrainerXmlPersister());
        String chosenPerisiter = (String) JOptionPane.showInputDialog(null, "Which chosenPerisiter do you want to use?",
                "Persister", JOptionPane.QUESTION_MESSAGE, null, persisters.keySet().toArray(), "JSON");
        new Controller(persisters.get(chosenPerisiter));
    }
}
