package TaskList;

/**
 * Represents a task with a description and completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description and sets it as not done.
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructs a new Task with the given description and completion status.
     * @param description The description of the task.
     * @param isDone The completion status of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }
  
    /**
     * Returns the description of the task.
     * This method retrieves the description that provides details about the task.
     * 
     * @return The description of the task.
     */
    public String getDescription() { 
        return description; 
    }
  
    /**
     * Returns the status of the task.
     * @return "X" if done, otherwise a space.
     */
    public String getStatus() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task formatted for file storage.
     * @return A formatted string for storage.
     */
    public abstract String toFileFormat();

    /**
     * Returns a string representation of the task.
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description;
    }
}