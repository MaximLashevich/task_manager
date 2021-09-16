package taskManager.models;

import taskManager.enums.TaskCategories;
import taskManager.enums.TaskPriorities;

public class SingleTask extends AbstractTask {

    private static String type = "Single task";

    public SingleTask(String type, TaskCategories categoryConst, TaskPriorities priorityConst, String description, String deadline) {
        super(type, categoryConst, priorityConst, description, deadline);
    }

}
