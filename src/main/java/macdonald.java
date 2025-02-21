import java.util.Scanner;
import java.util.ArrayList;

public class macdonald {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final String line = "___________________________________________________________";

    public static void listTasks() {
        System.out.println(line);
        if (tasks.isEmpty()) {
            System.out.println("Your task list is empty.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println(line);
    }

    public static void markTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).markAsDone();
            System.out.println(line);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + tasks.get(index - 1));
            System.out.println(line);
        } else {
            System.out.println("Your task is not in the list.");
        }
    }

    public static void unmarkTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).markAsNotDone();
            System.out.println(line);
            System.out.println("Ok, I've marked this task as not done yet:");
            System.out.println(" " + tasks.get(index - 1));
            System.out.println(line);
        }
    }

    public static void deleteTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            Task removedTask = tasks.remove(index - 1); // Store the removed task for confirmation
            Storage.saveTasks(tasks); // Save updated list to file

            System.out.println(line);
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            System.out.println(line);
        } else {
            System.out.println(line);
            System.out.println("ERROR: Invalid task number. Please enter a valid task number.");
            System.out.println(line);
        }
    }

    public static void addTask(String description) throws macdonaldException {
        if (description.isEmpty()) {
            throw new macdonaldException("Oh no! Your todo order cannot be empty.");
        }
        tasks.add(new Todo(description));
        Storage.saveTasks(tasks);

        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.size() - 1));
        System.out.println(line);
    }

    public static void addDeadline(String description) throws macdonaldException {
        int byIndex = description.indexOf("/by");
        if (byIndex == -1) {
            throw new macdonaldException("Invalid deadline format! Use: deadline <task> /by <time>");
        }
        String input = description.substring(9, byIndex).trim();
        String by = description.substring(byIndex + 4).trim();
        if (input.isEmpty() || by.isEmpty()) {
            throw new macdonaldException("Invalid deadline format! Your order for Task and date must not be empty.");
        }
        tasks.add(new Deadline(input, by));
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.size() - 1));
        System.out.println(line);
    }

    public static void addEvent(String description) throws macdonaldException {
        int fromIndex = description.indexOf("/from");
        int toIndex = description.indexOf("/to");
        if (fromIndex == -1 || toIndex == -1) {
            throw new macdonaldException("Invalid event format! Use: event <task> /from <start> /to <end>");
        }
        String input = description.substring(6, fromIndex).trim();
        String from = description.substring(fromIndex + 6, toIndex).trim();
        String to = description.substring(toIndex + 4).trim();
        if (input.isEmpty() || from.isEmpty() || to.isEmpty()) {
            throw new macdonaldException("Invalid event format! Task, start, and end time must not be empty.");
        }
        tasks.add(new Event(input, from, to));
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.size() - 1));
        System.out.println(line);
    }

    public static void main(String[] args) {
        /*
         * Prints the introduction message for the macdonald assistant.
         *
         * @param chatbotName The name of the assistant.
         */
        String chatbotName = "macdonald";
        System.out.println("Welcome to " + chatbotName + ", what can I do for you?");
        System.out.println("Input 'list' to view existing list or add a new Todo");
        System.out.println("____________________________________________________________");
        // ** Load saved tasks from file when the program starts **
        tasks.addAll(Storage.loadTasks());
        System.out.println("Loaded " + tasks.size() + " tasks from file.");

        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String input = in.nextLine();

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Saving tasks before exit...");
                    Storage.saveTasks(tasks); // Save tasks before quitting
                    System.out.println("Tasks saved successfully!");
                    System.out.println(" Have a pleasant day ahead, de de deng deng deng!");
                    System.out.println("____________________________________________________________");
                    break;
                } else if (input.equalsIgnoreCase("list")) {
                    listTasks();
                } else if (input.startsWith("mark ")) {
                    int index = Integer.parseInt(input.substring(5));
                    markTask(index);
                } else if (input.startsWith("unmark ")) {
                    int index = Integer.parseInt(input.substring(7));
                    unmarkTask(index);
                } else if (input.startsWith("delete ")) {
                    int index = Integer.parseInt(input.substring(7));
                    deleteTask(index);
                } else if (input.startsWith("todo ")) {
                    addTask(input.substring(5).trim());
                } else if (input.startsWith("deadline ")) {
                    addDeadline(input);
                } else if (input.startsWith("event ")) {
                    addEvent(input);
                } else {
                    throw new macdonaldException("Unknown order! Try 'todo', 'deadline', 'event', 'list', 'mark', or 'unmark'.");
                }
            } catch (macdonaldException e) {
                System.out.println("____________________________________________________________");
                System.out.println(" ERROR: " + e.getMessage());
                System.out.println("____________________________________________________________");
            } catch (NumberFormatException e) {
                System.out.println("____________________________________________________________");
                System.out.println(" ERROR: Invalid number format. Please enter a valid task number.");
                System.out.println("____________________________________________________________");
            } catch (Exception e) {
                System.out.println("____________________________________________________________");
                System.out.println(" ERROR: An unexpected error occurred: " + e.getMessage());
                System.out.println("____________________________________________________________");
            }
        }

        in.close();
    }
}

