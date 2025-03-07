package Commands;

import TaskList.TaskList;

/**
 * Command for listing all tasks in the task list.
 * This command executes the listing of tasks by calling the listTasks method of TaskList.
 */
public class ListCommand extends Command {
    /**
     * Executes the list tasks command by invoking the listTasks method of TaskList.
     * @param tasks The TaskList containing the tasks to be listed.
     */
    @Override
    public void execute(TaskList tasks) {
        tasks.listTasks();
    }
}