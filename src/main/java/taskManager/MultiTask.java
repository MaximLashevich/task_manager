package taskManager;

public class MultiTask extends AbstractTask {

    private static String type = "Multiple task";

    public MultiTask(String type, String category, String priority, String description, String deadline) {
        super(type, category, priority, description, deadline);
    }

}
