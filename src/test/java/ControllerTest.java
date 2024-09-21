import controller.*;
import model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    //@Test
    //@DisplayName("Test Controller")
    void testController() {
        Controller controller = new Controller(new WordTrainerPersister() {
            @Override
            public WordTrainer load() {
                WordEntry entry1 = new WordEntry("test", "http://example.com");
                List<WordEntry> entries = new ArrayList<>();
                entries.add(entry1);
                return new WordTrainer(entries, 0, 0, 0);
            }

            @Override
            public void save(WordTrainer trainer) {
                throw new UnsupportedOperationException();
            }
        });
        controller.check("tes");
        controller.check("test");
        assertEquals(2, controller._getTrainer().getNumAsked());
        assertEquals(1, controller._getTrainer().getNumRight());
        assertThrows(UnsupportedOperationException.class, controller::save);
    }
}
