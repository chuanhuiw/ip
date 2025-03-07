package TaskList;

/**
 * Represents a simple to-do task.
 */
public class Todo extends Task {
    /**
     * Constructs a Todo task with a description.
     * @param description The description of the to-do task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Constructs a Todo task with a description and completion status.
     * @param description The description of the to-do task.
     * @param isDone The completion status of the task.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns a string representation of the to-do task formatted for file storage.
     * @return A formatted string for storage.
     */
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Returns a string representation of the to-do task.
     * @return A formatted string representing the to-do task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}