package TaskList;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Constructs a Deadline task with a description and due date.
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Constructs a Deadline task with a description, due date, and completion status.
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     * @param isDone The completion status of the task.
     */
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns a string representation of the deadline task formatted for file storage.
     * @return A formatted string for storage.
     */
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    /**
     * Returns a string representation of the deadline task.
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}