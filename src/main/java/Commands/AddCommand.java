package Commands;

import TaskList.Todo;
import TaskList.Task;
import Exceptions.macdonaldException;
import Ui.ui;

import java.util.List;

/**
 * Command for adding a task to the task list.
 */
public class AddCommand {
    /**
     * Executes the add task command by adding a new task with the provided description.
     * Throws a macdonaldException if the description is invalid (null or empty).
     * @param tasks The list of tasks to which the new task will be added.
     * @param description The description of the new task to be added.
     * @throws macdonaldException If the task description is invalid.
     */
    public static void execute(List<Task> tasks, String description) throws macdonaldException {
        if (description == null || description.trim().isEmpty()) {
            throw new macdonaldException("Task description cannot be empty!");
        }
        Task newTask = new Todo(description);
        tasks.add(newTask);
        ui.printTaskAdded(newTask, tasks.size());
    }
}
