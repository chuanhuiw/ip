import java.util.Scanner;

public class cuckoo {
    public static void main(String[] args) {
        String logo = "cuckoo";
        System.out.println("ANYEONG! I am " + logo);
        System.out.println("What can I do for you?");
        System.out.println("______________________");
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while(!line.equals("bye")) {
            System.out.println(line);
            System.out.println("______________________");
            line = in.nextLine();
        }
        System.out.println("Bye.");
    }
}
