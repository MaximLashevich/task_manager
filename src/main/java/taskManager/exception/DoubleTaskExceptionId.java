package taskManager.exception;

public class DoubleTaskExceptionId extends Exception {
    private static final String MESSAGE_TEMPLATE =
            "Task with ID %d already exists.";

    public DoubleTaskExceptionId(Integer id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
