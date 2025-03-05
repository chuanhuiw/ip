package Commands;

import TaskList.TaskList;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks) {
        tasks.listTasks();
    }
}
