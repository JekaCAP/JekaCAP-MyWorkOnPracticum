package modelTest;

import org.junit.jupiter.api.Test;

public class SubtaskTest {

    @Test
    void testSetEpicToItself() {
        Epic epic = new Epic(1, "Epic", "Описание");
        Subtask subtask = new Subtask(1, "Подзадача", "Описание", 2);

        assertFalse(subtask.setEpic(subtask), "Подзадача не может быть установлена как самостоятельная задача");
    }
}