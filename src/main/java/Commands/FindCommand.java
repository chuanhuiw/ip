package Commands;

import TaskList.Task;
import TaskList.TaskList;
import Ui.ui;

import java.util.ArrayList;
import java.util.List;

public class FindCommand {
    public static void execute(TaskList tasks, String keyword) {
        List<Task> matchingTasks = new ArrayList<>();

        for (Task task : tasks.getTasks()) {  // Ensure TaskList has a method to return tasks
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }

        ui.printMatchingTasks(matchingTasks);
    }
}
