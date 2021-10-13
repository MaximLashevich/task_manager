package taskManager.exception;

public class NotUniqueDescriptionException extends Exception {
    private static final String MESSAGE_TEMPLATE =
            "Task with description %s already exists";

    public NotUniqueDescriptionException(String description) {
        super(String.format(MESSAGE_TEMPLATE, description));
    }

}
