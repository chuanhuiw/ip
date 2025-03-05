package Commands;

import TaskList.Task;
import Exceptions.macdonaldException;
import Ui.ui;

import java.util.List;

public class DeleteCommand {
    public static void execute(List<Task> tasks, int index) throws macdonaldException {
        if (index < 0 || index >= tasks.size()) {
            throw new macdonaldException("Invalid task number! Task does not exist.");
        }
        Task removedTask = tasks.remove(index);
        ui.printTaskDeleted(removedTask, tasks.size());
    }
}
