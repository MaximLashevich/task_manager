package taskManager.models;

import taskManager.enums.TaskPriorities;
import taskManager.enums.TaskCategories;

public class MultiTask extends AbstractTask {

    private static String type = "Multiple task";

    public MultiTask(String type, TaskCategories categoryConst, TaskPriorities priorityConst, String description, String deadline) {
        super(type, categoryConst, priorityConst, description, deadline);
    }

}
