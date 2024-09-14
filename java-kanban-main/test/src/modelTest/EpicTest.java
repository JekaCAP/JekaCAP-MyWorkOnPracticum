import modelTest.Epic;
import modelTest.Subtask;
import org.junit.jupiter.api.Test;

public class EpicTest {

    @Test
    void testAddSubtaskToItself() {
        Epic epic = new Epic(1, "Epic", "Описание");
        Subtask subtask = new Subtask(1, "Подзадача", "Описание", 2);

        assertFalse(epic.addSubtask(epic.getId()), "Epic не может быть добавлен в качестве отдельной подзадачи");
    }
}