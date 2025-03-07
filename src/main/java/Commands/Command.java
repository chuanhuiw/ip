package Commands;

import TaskList.TaskList;

/**
 * Abstract base class for all command types in the application.
 * Defines the structure for executing a command on a TaskList.
 */
public abstract class Command {
    /**
     * Executes a command on the provided TaskList.
     * @param tasks The TaskList to be modified by the command.
     */
    public abstract void execute(TaskList tasks);
}
