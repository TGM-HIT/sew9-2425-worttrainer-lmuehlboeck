import model.WordEntry;
import model.WordTrainer;
import model.WordTrainerJsonPersister;
import model.WordTrainerPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest {
    @Test
    @DisplayName("Test JSON save")
    void testJSONSave() {
        WordEntry entry1 = new WordEntry("test1", "http://example.com");
        WordEntry entry2 = new WordEntry("test2", "http://example.com");
        List<WordEntry> entries = new ArrayList<>();
        entries.add(entry1);
        entries.add(entry2);
        WordTrainer trainer = new WordTrainer(entries, 0, 1, 1);
        WordTrainerPersister persister = new WordTrainerJsonPersister("./word_trainer.json");
        persister.save(trainer);
        assertTrue(new File("./word_trainer.json").exists());
    }

    @Test
    @DisplayName("Test JSON save and load")
    void testJSONSaveLoad() {
        WordEntry entry1 = new WordEntry("test1", "http://example.com");
        WordEntry entry2 = new WordEntry("test2", "http://example.com");
        List<WordEntry> entries = new ArrayList<>();
        entries.add(entry1);
        entries.add(entry2);
        WordTrainer trainer = new WordTrainer(entries, 0, 1, 1);
        WordTrainerPersister persister = new WordTrainerJsonPersister();
        persister.save(trainer);
        WordTrainer loadedTrainer = persister.load();
        assertNotNull(loadedTrainer);
        assertEquals(trainer.getEntries(), loadedTrainer.getEntries());
        assertEquals(trainer.getSelectedEntry(), loadedTrainer.getSelectedEntry());
        assertEquals(trainer.getNumAsked(), loadedTrainer.getNumAsked());
        assertEquals(trainer.getNumRight(), loadedTrainer.getNumRight());
    }
}
