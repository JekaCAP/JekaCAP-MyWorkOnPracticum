package modelTest;

import org.junit.jupiter.api.Test;
public class TaskTest {

    @Test
    void testEqualityById() {
        Task task1 = new Task(1, "Название", "Описание");
        Task task2 = new Task(1, "Другое название", "Другое Описание");
        Task task3 = new Task(2, "Название", "Описание");

        assertEquals(task1, task2, "Задачи с одинаковыми идентификаторами должны быть равны");
        assertNotEquals(task1, task3, "Задачи с разными идентификаторами не должны быть равны");
    }

    @Test
    void testEqualityByType() {
        Task task1 = new Task(1, "Название", "Описание");
        Epic epic1 = new Epic(1, "Название", "Описание");
        Subtask subtask1 = new Subtask(1, "Название", "Описание", 1);

        assertNotEquals(task1, epic1, "Задача и Epic не должны быть равны");
        assertNotEquals(task1, subtask1, "Задача и подзадача не должны быть равны");
    }
}