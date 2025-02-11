package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        tasks.addTask("Complete assignment", "High");
        tasks.addTask("Buy ticket", "Medium");
        tasks.addTask("Call friend", "Low");
        tasks.addTask("Prepare for meeting", "High");

        System.out.println("Original task list: ");
        tasks.printTasks();
        System.out.println();

        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskName().equalsIgnoreCase("Buy ticket")) {
                ((TaskList.TaskIterator) iterator).markCompleted("Buy ticket");
                break;
            }
        }

        System.out.println("Updated task list: ");
        tasks.printTasks();
        System.out.println();


        System.out.println("Uncompleted task list: ");
        iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (!task.isCompleted()) {
                System.out.println(task);
            }
        }
        System.out.println();

        // remove all completed tasks and print the final list
        System.out.println("Removing completed tasks...");
        System.out.println();
        iterator = tasks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isCompleted()) {
                iterator.remove();
            }
        }

        System.out.println("Task list after removing completed tasks: ");
        tasks.printTasks();
        System.out.println();
    }
}