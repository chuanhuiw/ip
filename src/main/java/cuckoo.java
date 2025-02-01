import java.util.Scanner;

public class cuckoo {
    public static void main(String[] args) {
        String chatbotName = "cuckoo";
        System.out.println("ANNYEONG! I am " + chatbotName);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
        String[] tasks = new String[100];
        int count = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                for (int i = 0; i < count; i++) {
                    System.out.println(" " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else {
                if (count < 100) {
                    tasks[count++] = input;
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
