package Storage;

import TaskList.Deadline;
import TaskList.Event;
import TaskList.Task;
import TaskList.Todo;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static final String FILE_PATH = System.getProperty("user.home") + "/macdonald_tasks.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists() && !parentDir.mkdirs()) {
            System.out.println("WARNING: Failed to create data folder.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR: Unable to save tasks.");
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);
        //System.out.print("Here is your file path: ");
        //System.out.println(file.getAbsolutePath());

        if (!file.exists()) {
            return tasks; // Return empty list if file doesn't exist
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    Task task = parseTask(line);
                    if (task != null) {
                        tasks.add(task);
                    }
                } catch (Exception e) {
                    System.out.println("WARNING: Skipping corrupted line -> " + line);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("ERROR: Unable to load tasks.");
        }

        return tasks;
    }

    private static Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            return null; // Corrupt data, return null
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
            case "T":
                return new Todo(description, isDone);
            case "D":
                if (parts.length == 4) {
                    return new Deadline(description, parts[3], isDone);
                }
                break;
            case "E":
                if (parts.length == 5) {
                    return new Event(description, parts[3], parts[4], isDone);
                }
                break;
        }

        return null; // Invalid format
    }
}
