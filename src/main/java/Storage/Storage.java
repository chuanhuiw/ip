package Storage;

import TaskList.Deadline;
import TaskList.Event;
import TaskList.Task;
import TaskList.Todo;

import java.io.*;
import java.util.ArrayList;

/**
 * Handles loading and saving tasks to a file.
 */
public class Storage {
    private static final String FILE_PATH = System.getProperty("user.home") + "/macdonald_tasks.txt";

    /**
     * Saves the list of tasks to a file.
     * @param tasks The list of tasks to save.
     */
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

    /**
     * Loads tasks from the file.
     * @return A list of tasks loaded from the file.
     */
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

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

    /**
     * Parses a line from the file and converts it into a Task object.
     * @param line The line containing task data.
     * @return The corresponding Task object, or null if the data is invalid.
     */
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