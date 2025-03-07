package TaskList;

import Commands.DeleteCommand;
import Commands.MarkCommand;
import Commands.UnmarkCommand;
import Exceptions.macdonaldException;
import Storage.Storage;
import Ui.ui;

import java.util.ArrayList;

/**
 * Manages a list of tasks, including adding, deleting, marking, and saving tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Loads tasks from storage and prints a message indicating the number of tasks loaded.
     */
    public void loadTasks() {
        tasks.addAll(Storage.loadTasks());
        ui.printTaskLoadMessage(tasks.size());
    }

    /**
     * Saves tasks to storage.
     */
    public void saveTasks() {
        Storage.saveTasks(tasks);
    }

    /**
     * Displays the current list of tasks.
     */
    public void listTasks() {
        ui.printTaskList(tasks);
    }

    /**
     * Adds a new task to the list and saves the updated list.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
        ui.printTaskAdded(task, tasks.size());
    }

    /**
     * Deletes a task at the specified index and saves the updated list.
     * @param index The index of the task to be deleted.
     * @throws macdonaldException If the index is invalid.
     */
    public void deleteTask(int index) throws macdonaldException {
        DeleteCommand.execute(tasks, index);
        saveTasks();
    }

    /**
     * Marks a task at the specified index as done and saves the updated list.
     * @param index The index of the task to be marked.
     * @throws macdonaldException If the index is invalid.
     */
    public void markTask(int index) throws macdonaldException {
        MarkCommand.execute(tasks, index);
        saveTasks();
    }

    /**
     * Unmarks a task at the specified index and saves the updated list.
     * @param index The index of the task to be unmarked.
     * @throws macdonaldException If the index is invalid.
     */
    public void unmarkTask(int index) throws macdonaldException {
        UnmarkCommand.execute(tasks, index);
        saveTasks();
    }
}