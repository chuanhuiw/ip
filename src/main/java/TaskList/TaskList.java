package TaskList;

import Commands.DeleteCommand;
import Commands.MarkCommand;
import Commands.UnmarkCommand;
import Exceptions.macdonaldException;
import Storage.Storage;
import Ui.ui;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void loadTasks() {
        tasks.addAll(Storage.loadTasks());
        ui.printTaskLoadMessage(tasks.size());
    }

    public void saveTasks() {
        Storage.saveTasks(tasks);
    }

    public void listTasks() {
        ui.printTaskList(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
        ui.printTaskAdded(task, tasks.size());
    }

    public void deleteTask(int index) throws macdonaldException {
        DeleteCommand.execute(tasks, index);
        saveTasks();
    }

    public void markTask(int index) throws macdonaldException {
        MarkCommand.execute(tasks, index);
        saveTasks();
    }

    public void unmarkTask(int index) throws macdonaldException {
        UnmarkCommand.execute(tasks, index);
        saveTasks();
    }
}
