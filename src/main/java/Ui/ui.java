package Ui;

import TaskList.Task;
import java.util.List;

/**
 * Handles all user interface interactions, including printing messages and task lists.
 */
public class ui {
    private static final String line = "___________________________________________________________";

    /**
     * Prints the welcome message when the application starts.
     */
    public static void printWelcomeMessage() {
        System.out.println("Welcome to macdonald! What can I order for you?");
        System.out.println(line);
    }

    /**
     * Prints the exit message when the application terminates.
     */
    public static void printExitMessage() {
        System.out.println("DE DE DE DENG DENG! Goodbye! Have a great day!");
        System.out.println(line);
    }

    /**
     * Prints the list of tasks.
     * @param tasks The list of tasks to be displayed.
     */
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

    /**
     * Prints a message indicating that a task has been added.
     * @param task The task that was added.
     * @param size The current number of tasks.
     */
    public static void printTaskAdded(Task task, int size) {
        System.out.println("Added: " + task);
        System.out.println("You now have " + size + " tasks.");
        System.out.println(line);
    }

    /**
     * Prints a message indicating that a task has been deleted.
     * @param task The task that was deleted.
     * @param size The remaining number of tasks.
     */
    public static void printTaskDeleted(Task task, int size) {
        System.out.println("Deleted: " + task);
        System.out.println("You now have " + size + " tasks remaining.");
        System.out.println(line);
    }

    /**
     * Prints a message indicating that a task has been marked as done.
     * @param task The task that was marked as done.
     */
    public static void printTaskMarked(Task task) {
        System.out.println("Marked as done: " + task);
        System.out.println(line);
    }

    /**
     * Prints a message indicating that a task has been unmarked.
     * @param task The task that was unmarked.
     */
    public static void printTaskUnmarked(Task task) {
        System.out.println("Marked as not done: " + task);
        System.out.println(line);
    }

    /**
     * Prints an error message.
     * @param message The error message to be displayed.
     */
    public static void printError(String message) {
        System.out.println("ERROR: " + message);
        System.out.println(line);
    }

    /**
     * Prints a message indicating the number of tasks loaded from storage.
     * @param taskCount The number of tasks loaded.
     */
    public static void printTaskLoadMessage(int taskCount) {
        System.out.println("Loaded " + taskCount + " tasks.");
    }

    /**
     * Prints the tasks that match a specific criteria to the console.
     * If the list of tasks is empty, it informs the user that no matching tasks were found.
     * Otherwise, it prints the matching tasks with their index in the list.
     * 
     * @param tasks The list of tasks to be printed, which are assumed to match some criteria.
     */
    public static void printMatchingTasks(List<Task> tasks) {
        System.out.println(line);
        if (tasks.isEmpty()) {  // Use 'tasks' instead of 'matchingTasks'
            System.out.println("No matching orders found.");
        } else {
            System.out.println("Here are the matching orders in your list:");
            for (int i = 0; i < tasks.size(); i++) {  // Use 'tasks' instead of 'matchingTasks'
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println(line);
    }

}
