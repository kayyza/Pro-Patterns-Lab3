package org.example;

// linked list to store tasks

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TaskList implements Iterable<Task> {
    private Node head;
    private int size;

    private class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }
    // end of Node inner class

    // add a new task to the list
    public void addTask(String name, String priority) {
        Task newTask = new Task(name, priority);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Iterator<Task> iterator() {
        return new TaskIterator();
    }

    // custom iterator class for task list
    public class TaskIterator implements Iterator<Task> {
        private Node current = head;
        private Node previous = null;

        // checks if more tasks exist
        public boolean hasNext() {
            return current != null;
        }

        // return the next task
        public Task next() {
            if (!hasNext()) throw new NoSuchElementException();
            Task task = current.task;
            previous = current;
            current = current.next;
            return task;
        }

        // removes the last task returned by next(), (remove the last returned task)
        public void remove() {
            if (previous == null) throw new IllegalStateException("Call next() before remove()");

            if (head == previous) {
                head = head.next; // remove the first element
            } else { // removing a middle element
                Node temp = head;
                while (temp.next != previous) {
                    temp = temp.next;
                }
                temp.next = current;
            }
            size--;
            previous = null; // prevents the consecutive removal
        }

        public void markCompleted(String name) {
            Node temp = head;
            while (temp != null) {
                if (temp.task.getTaskName().equalsIgnoreCase(name)) {
                    temp.task.markCompleted();
                    return;
                }
                temp = temp.next;
            }
        }

        // only iterate over uncompleted tasks
        public void filterUncompletedTasks() {
            while (current != null && current.task.isCompleted()) {
                current = current.next;
            }
        }

    }
    // print the task list
    public void printTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }
}
