package Commands;

import TaskList.Todo;
import TaskList.Task;
import Exceptions.macdonaldException;
import Ui.ui;

import java.util.List;

public class AddCommand {
    public static void execute(List<Task> tasks, String description) throws macdonaldException {
        if (description == null || description.trim().isEmpty()) {
            throw new macdonaldException("Task description cannot be empty!");
        }
        Task newTask = new Todo(description);
        tasks.add(newTask);
        ui.printTaskAdded(newTask, tasks.size());
    }
}
