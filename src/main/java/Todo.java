public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    //returns string for to-do
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
