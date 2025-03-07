package Parser;

import TaskList.TaskList;
import Exceptions.macdonaldException;
import TaskList.Todo;
import TaskList.Deadline;
import TaskList.Event;
import Commands.FindCommand;

/**
 * Parses user input and executes commands accordingly.
 */
public class Parser {
    /**
     * Parses the given command and executes it on the task list.
     * @param input The user command input.
     * @param tasks The task list to operate on.
     * @throws macdonaldException If the command format is invalid.
     */
    public static void parseCommand(String input, TaskList tasks) throws macdonaldException {
        if (input.equalsIgnoreCase("list")) {
            tasks.listTasks();
        } else if (input.startsWith("todo ")) {
            tasks.addTask(new Todo(input.substring(5).trim()));
        } else if (input.startsWith("deadline ")) {
            String[] parts = input.split(" /by ");
            if (parts.length < 2) throw new macdonaldException("Invalid deadline format! Use: deadline <task> /by <time>");
            tasks.addTask(new Deadline(parts[0].substring(9).trim(), parts[1].trim()));
        } else if (input.startsWith("event ")) {
            String[] parts = input.split(" /from | /to ");
            if (parts.length < 3) throw new macdonaldException("Invalid event format! Use: event <task> /from <start> /to <end>");
            tasks.addTask(new Event(parts[0].substring(6).trim(), parts[1].trim(), parts[2].trim()));
        } else if (input.startsWith("mark ")) {
            tasks.markTask(parseIndex(input, 5));
        } else if (input.startsWith("unmark ")) {
            tasks.unmarkTask(parseIndex(input, 7));
        } else if (input.startsWith("delete ")) {
            tasks.deleteTask(parseIndex(input, 7));
        } else if (input.startsWith("find ")) {
            FindCommand.execute(tasks, input.substring(5).trim());
        } else {
            throw new macdonaldException("Unknown command! Use 'todo', 'deadline', 'event', 'mark', 'unmark', 'delete', or 'list'.");
        }
    }

    /**
     * Extracts the task index from a command input.
     * @param input The command string.
     * @param prefixLength The length of the command prefix.
     * @return The parsed index.
     * @throws macdonaldException If the index is not a valid number.
     */
    private static int parseIndex(String input, int prefixLength) throws macdonaldException {
        try {
            return Integer.parseInt(input.substring(prefixLength).trim()) - 1;
        } catch (NumberFormatException e) {
            throw new macdonaldException("Invalid number format! Enter a valid task number.");
        }
    }
}
