import java.util.Scanner;

public class macdonald {
    private static final int MAX_SIZE = 100;
    private static final String LINE = "___________________________________________________________";
    private static final Task[] tasks = new Task[MAX_SIZE];
    private static int taskCount = 0;

    public static void listTasks() {
        System.out.println(LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
        System.out.println(LINE);
    }

    public static void markTask(int index) {
        if (index >= 1 && index <= taskCount) {
            tasks[index - 1].markAsDone();
            System.out.println(LINE);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + tasks[index - 1]);
            System.out.println(LINE);
        }
    }

    public static void unmarkTask(int index) {
        if (index >= 1 && index <= taskCount) {
            tasks[index - 1].markAsNotDone();
            System.out.println(LINE);
            System.out.println("Ok, I've marked this task as not done yet:");
            System.out.println(" " + tasks[index - 1]);
            System.out.println(LINE);
        }
    }

    public static void addTask(String description) {
        if (taskCount < MAX_SIZE) {
            tasks[taskCount++] = new Todo(description);
            System.out.println(LINE);
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + tasks[taskCount - 1]);
            System.out.println(LINE);
        } else {
            System.out.println(" Task list is full! No more money to buy cheeseburger liao...");
        }
    }

    public static void addDeadline(String description) {
        int byIndex = description.indexOf("/by");
        if (byIndex == -1) {
            System.out.println("Invalid deadline format! Use: deadline <task> /by <time>");
            return;
        }
        String input = description.substring(9, byIndex).trim();
        String by = description.substring(byIndex + 4).trim();
        if (input.isEmpty() || by.isEmpty()) {
            System.out.println("Invalid deadline format! Task and date must not be empty.");
            return;
        }

        if (taskCount < MAX_SIZE) {
            tasks[taskCount++] = new Deadline(input, by);
            System.out.println(LINE);
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + tasks[taskCount - 1]);
            System.out.println(LINE);
        } else {
            System.out.println(" Task list is full! No more money to buy cheeseburger liao...");
        }
    }

    public static void addEvent(String description) {
        int fromIndex = description.indexOf("/from");
        int toIndex = description.indexOf("/to");

        if (fromIndex == -1 || toIndex == -1) {
            System.out.println("Invalid event format! Use: event <task> /from <start> /to <end>");
            return;
        }

        String input = description.substring(6, fromIndex).trim();
        String from = description.substring(fromIndex + 6, toIndex).trim();
        String to = description.substring(toIndex + 4).trim();

        if (input.isEmpty() || from.isEmpty() || to.isEmpty()) {
            System.out.println("Invalid event format! Task, start, and end time must not be empty.");
            return;
        }

        if (taskCount < MAX_SIZE) {
            tasks[taskCount++] = new Event(input, from, to);
            System.out.println(LINE);
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + tasks[taskCount - 1]);
            System.out.println(LINE);
        } else {
            System.out.println(" Task list is full! No more money to buy cheeseburger liao...");
        }
    }

    public static void main(String[] args) {
        String chatbotName = "macdonald";
        System.out.println("Welcome to " + chatbotName + ", what can I do for you?");
        System.out.println("Input 'list' to view existing list or add a new Todo");
        System.out.println(LINE);
        Scanner in = new Scanner(System.in);

        while (true) {
            String input = in.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(LINE);
                System.out.println(" Have a pleasant day ahead, de de deng deng deng!");
                System.out.println(LINE);
                break;
            } else if (input.equalsIgnoreCase("list")) {
                listTasks();
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5));
                markTask(index);
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7));
                unmarkTask(index);
            } else if (input.startsWith("todo ")) {
                addTask(input.substring(5).trim());
            } else if (input.startsWith("deadline ")) {
                addDeadline(input);
            } else if (input.startsWith("event ")) {
                addEvent(input);
            } else {
                System.out.println("Unknown order! Try 'todo', 'deadline', 'event', 'list', 'mark', or 'unmark'.");
            }
        }

        in.close();
    }
}
