package Commands;

import TaskList.Task;
import Exceptions.macdonaldException;
import Ui.ui;

import java.util.List;

/**
 * Command for marking a task as completed (done).
 * This command marks the task at the specified index as done.
 */
public class MarkCommand {
    /**
     * Executes the mark task as done command by updating the status of the task at the given index.
     * Throws a macdonaldException if the index is invalid.
     * @param tasks The list of tasks containing the task to be marked.
     * @param index The index of the task to be marked as done.
     * @throws macdonaldException If the task index is invalid.
     */
    public static void execute(List<Task> tasks, int index) throws macdonaldException {
        if (index < 0 || index >= tasks.size()) {
            throw new macdonaldException("Invalid task number! Task does not exist.");
        }
        Task task = tasks.get(index);
        task.markAsDone();
        ui.printTaskMarked(task);
    }
}