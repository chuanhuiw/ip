import Exceptions.macdonaldException;
import Parser.Parser;
import TaskList.TaskList;
import Ui.ui;

import java.util.Scanner;

/**
 * The main class for the macdonald task management application.
 */
public class macdonald {
    private static final TaskList tasks = new TaskList();

    /**
     * The entry point of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ui.printWelcomeMessage();

        // Load saved tasks
        tasks.loadTasks();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("bye")) {
                    tasks.saveTasks();
                    ui.printExitMessage();
                    break;
                }
                Parser.parseCommand(input, tasks);
            } catch (macdonaldException e) {
                ui.printError(e.getMessage());
            }
        }

        scanner.close();
    }
}
