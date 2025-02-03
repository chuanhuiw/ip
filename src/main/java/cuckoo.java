import java.util.Scanner;

class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatus() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description;
    }
}

class Todo extends Task {
    public Todo(String description) {
        super(description);
    }
}

public class cuckoo {
    private static Task[] tasks = new Task[100];
    private static int taskCount = 0;

    public static void listTasks() {
        System.out.println("___________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
        System.out.println("___________________________________________________________");
    }

    public static void markTask(int index) {
        if (index >= 1 && index <= taskCount) {
            tasks[index - 1].markAsDone();
            System.out.println("___________________________________________________________");
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + tasks[index - 1]);
            System.out.println("___________________________________________________________");
        }
    }

    public static void unmarkTask(int index) {
        if (index >= 1 && index <= taskCount) {
            tasks[index - 1].markAsNotDone();
            System.out.println("___________________________________________________________");
            System.out.println("Ok, I've marked this task as not done yet:");
            System.out.println(" " + tasks[index - 1]);
            System.out.println("___________________________________________________________");
        }
    }

    public static void main(String[] args) {
        String chatbotName = "cuckoo";
        System.out.println("ANNYEONG! I am " + chatbotName);
        System.out.println("Input 'list' to view existing list or add a new Todo");
        System.out.println("____________________________________________________________");
        Scanner in = new Scanner(System.in);

        while (true) {
            String input = in.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye bye. Hope to see you again soon!");
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
            } else {
                if (taskCount < 100) {
                    tasks[taskCount++] = new Todo(input);
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println(" Task list is full!");
                }
            }
        }

        in.close();
    }
}
