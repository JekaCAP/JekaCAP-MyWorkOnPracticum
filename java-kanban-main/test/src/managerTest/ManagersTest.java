package managerTest;

import org.junit.jupiter.api.Test;

import modelTest.Task;
import modelTest.Epic;
import modelTest.Subtask;

public class ManagersTest {
    @Test
    void getDefaultShouldReturnInitializedTaskManager() {
        TaskManager manager = Managers.getDefault();
        assertNotNull(manager, "Диспетчер задач по умолчанию не должен иметь значения null");
    }

    @Test
    void getDefaultHistoryShouldReturnInitializedHistoryManager() {
        HistoryManager historyManager = Managers.getDefaultHistory();
        assertNotNull(historyManager, "Значение диспетчера истории по умолчанию не должно быть равно null");
    }
}