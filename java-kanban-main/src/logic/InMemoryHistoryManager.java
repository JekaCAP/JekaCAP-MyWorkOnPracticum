package logic;

import tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private final Node head = new Node(null, null, null);
    private final Node tail = new Node(null, null, null);

    {
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void add(Task task) {
        if (task == null) return;
        int id = task.getId();
        Node existingNode = nodeMap.get(id);

        if (existingNode != null) {
            removeNode(existingNode);
        }

        Node newNode = new Node(head, task, tail);
        head.next = newNode;
        tail.prev = newNode;
        nodeMap.put(id, newNode);
    }

    @Override
    public void remove(int id) {
        Node nodeToRemove = nodeMap.get(id);
        if (nodeToRemove != null) {
            removeNode(nodeToRemove);
        }
    }

    @Override
    public List<Task> getHistory() {
        List<Task> history = new ArrayList<>();
        Node currentNode = head.next;
        while (currentNode != tail) {
            history.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return history;
    }

    private void removeNode(Node node) {
        if (node == null) return;
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        nodeMap.remove(node.data.getId());
    }

    private static class Node {
        public Task data;
        public Node next;
        public Node prev;

        public Node(Node prev, Task data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}