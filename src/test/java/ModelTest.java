import model.WordEntry;
import model.WordTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    @Test
    @DisplayName("Test WordEntry")
    void testWordEntryParamCheck() {
        WordEntry entry = new WordEntry("test", "http://example.com");
        assertEquals("test", entry.getWord());
        assertEquals("http://example.com", entry.getUrl());
        assertThrows(IllegalArgumentException.class, () -> new WordEntry(null, "http://example.com"));
        assertThrows(IllegalArgumentException.class, () -> new WordEntry("", "http://example.com"));
        assertThrows(IllegalArgumentException.class, () -> new WordEntry("test", null));
        assertThrows(IllegalArgumentException.class, () -> new WordEntry("test", "example.com"));
    }

    @Test
    @DisplayName("Test param checks of WordTrainer")
    void testWordTrainerParamCheck() {
        WordEntry entry1 = new WordEntry("test2", "http://example.com");
        List<WordEntry> entries = new ArrayList<>();
        entries.add(entry1);
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer(null, 0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer(entries, 100, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer(entries, 0, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> new WordTrainer(entries, 0, 1, -1));
    }

    @Test
    @DisplayName("Test WordTrainer")
    void testWordTrainer() {
        WordEntry entry1 = new WordEntry("test1", "http://example.com");
        WordEntry entry2 = new WordEntry("test2", "http://example.com");
        List<WordEntry> entries = new ArrayList<>();
        entries.add(entry1);
        entries.add(entry2);
        WordTrainer trainer = new WordTrainer(entries, 0, 1, 1);
        assertEquals(entries, trainer.getEntries());
        assertEquals(entry1, trainer.getSelectedEntry());
        assertEquals(1, trainer.getNumAsked());
        assertEquals(1, trainer.getNumRight());
        trainer.selectEntry(1);
        assertEquals(entry2, trainer.getSelectedEntry());
        trainer.setNumAsked(2);
        assertEquals(2, trainer.getNumAsked());
        trainer.setNumRight(2);
        assertEquals(2, trainer.getNumRight());
    }
}
