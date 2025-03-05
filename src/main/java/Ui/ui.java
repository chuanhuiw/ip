package Ui;

import TaskList.Task;
import java.util.List;

public class ui {
    private static final String line = "___________________________________________________________";
    public static void printWelcomeMessage() {
        System.out.println("Welcome to macdonald! What can I order for you?");
        System.out.println(line);
    }

    public static void printExitMessage() {
        System.out.println("DE DE DE DENG DENG! Goodbye! Have a great day!");
        System.out.println(line);
    }

    public static void printTaskList(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            System.out.println(line);
        } else {
            System.out.println("Here are your tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println(line);
        }
    }

    public static void printTaskAdded(Task task, int size) {
        System.out.println("Added: " + task);
        System.out.println("You now have " + size + " tasks.");
        System.out.println(line);
    }

    public static void printTaskDeleted(Task task, int size) {
        System.out.println("Deleted: " + task);
        System.out.println("You now have " + size + " tasks remaining.");
        System.out.println(line);
    }

    public static void printTaskMarked(Task task) {
        System.out.println("Marked as done: " + task);
        System.out.println(line);
    }

    public static void printTaskUnmarked(Task task) {
        System.out.println("Marked as not done: " + task);
        System.out.println(line);
    }

    public static void printError(String message) {
        System.out.println("ERROR: " + message);
        System.out.println(line);
    }

    public static void printTaskLoadMessage(int taskCount) {
        System.out.println("Loaded " + taskCount + " tasks.");
    }
}
