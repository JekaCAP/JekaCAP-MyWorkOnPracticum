package test;

import managerTest.InMemoryTaskManager;
import managerTest.TaskManager;
import modelTest.Epic;
import modelTest.Subtask;
import modelTest.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new InMemoryTaskManager();
    }

    @Test
    public void testAddTask() {
        Task task = new Task(1, "Задача 1", "Описание 1");
        taskManager.addTask(task);
        Task retrievedTask = taskManager.getTaskById(1);
        assertNotNull(retrievedTask);
        assertEquals("Задача 1", retrievedTask.getTitle());
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task(1, "Задача 1", "Описание 1");
        taskManager.addTask(task);
        task.setTitle("Updated Задача 1");
        taskManager.updateTask(task);
        Task updatedTask = taskManager.getTaskById(1);
        assertEquals("Updated Задача 1", updatedTask.getTitle());
    }

    @Test
    public void testRemoveTaskById() {
        Task task = new Task(1, "Задача 1", "Описание 1");
        taskManager.addTask(task);
        taskManager.removeTaskById(1);
        assertNull(taskManager.getTaskById(1));
    }

    @Test
    public void testAddEpic() {
        Epic epic = new Epic(1, "Задача 1", "Epic Описание 1");
        taskManager.addEpic(epic);
        Epic retrievedEpic = taskManager.getEpicById(1);
        assertNotNull(retrievedEpic);
        assertEquals("Задача 1", retrievedEpic.getTitle());
    }

    @Test
    public void testAddSubtaskToEpic() {
        Epic epic = new Epic(1, "Задача 1", "Epic Описание 1");
        taskManager.addEpic(epic);
        Subtask subtask = new Subtask(1, "Подзадача 1", "Подзадача Описание 1", epic.getId());
        taskManager.addSubtask(subtask);
        Epic retrievedEpic = taskManager.getEpicById(1);
        assertEquals(1, retrievedEpic.getSubtaskIds().size());
    }

    @Test
    public void testRemoveSubtaskById() {
        Epic epic = new Epic(1, "Задача 1", "Epic Описание 1");
        taskManager.addEpic(epic);
        Subtask subtask = new Subtask(1, "Подзадача 1", "Подзадача Описание 1", epic.getId());
        taskManager.addSubtask(subtask);
        taskManager.removeSubtaskById(1);
        assertNull(taskManager.getSubtaskById(1));
        assertTrue(taskManager.getEpicById(1).getSubtaskIds().isEmpty());
    }

    @Test
    public void testHistory() {
        Task task1 = new Task(1, "Задача 1", "Описание 1");
        Task task2 = new Task(2, "Задача 2", "Описание 2");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.getTaskById(1);
        taskManager.getTaskById(2);
        taskManager.getTaskById(1);

        assertEquals(List.of(task2, task1), taskManager.getHistory());
    }
}
