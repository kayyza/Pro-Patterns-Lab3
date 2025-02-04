package org.example;

public class Task {
    private String taskName;
    private String priority;
    private boolean completed;

    public Task(String taskName, String priority) {
        this.taskName = taskName;
        this.priority = priority;
        this.completed = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", priority='" + priority + '\'' +
                ", completed=" + completed +
                '}';
    }
}
