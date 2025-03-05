package Commands;

import TaskList.TaskList;

public abstract class Command {
    public abstract void execute(TaskList tasks);
}
