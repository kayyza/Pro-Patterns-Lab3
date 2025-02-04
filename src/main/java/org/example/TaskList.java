package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TaskList {
    private Node head;

    private class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            next = null;
        }
    }

    // method to add new tasks
    public void addTask(String name, String priority) {
        Node task = new Node(new Task(name, priority));
        if (head == null) {
            head = task;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = task;
        }
    }

    public Iterator iterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator<Task> {
        private Node current = head;
        private Node previous = null;

        public boolean hasNext() {
            return current != null;
        }

        public Task next() {
            if (!hasNext()) throw new NoSuchElementException(); {
                Task task = current.task;
                previous = current;
                current = current.next;
                return task;
            }
        }

        public void remove() {

        }
    }
}
