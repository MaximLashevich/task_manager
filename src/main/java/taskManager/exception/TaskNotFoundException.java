package taskManager.exception;

public class TaskNotFoundException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE =
            "Task with given ID:%d not found";

    public TaskNotFoundException(Integer id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
