package taskManager;

public class SingleTask extends AbstractTask {

    private static String type = "Single task";

    public SingleTask(String type, String category, String priority, String description, String deadline) {
        super(type, category, priority, description, deadline);
    }

}
