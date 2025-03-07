package Commands;

import TaskList.Task;
import Exceptions.macdonaldException;
import Ui.ui;

import java.util.List;

/**
 * Command for deleting a task from the task list.
 */
public class DeleteCommand {
    /**
     * Executes the delete task command by removing the task at the given index.
     * Throws a macdonaldException if the index is out of bounds or invalid.
     * @param tasks The list of tasks from which the task will be deleted.
     * @param index The index of the task to be deleted.
     * @throws macdonaldException If the task index is invalid.
     */
    public static void execute(List<Task> tasks, int index) throws macdonaldException {
        if (index < 0 || index >= tasks.size()) {
            throw new macdonaldException("Invalid task number! Task does not exist.");
        }
        Task removedTask = tasks.remove(index);
        ui.printTaskDeleted(removedTask, tasks.size());
    }
}