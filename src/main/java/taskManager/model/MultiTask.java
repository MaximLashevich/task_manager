package taskManager.model;

import taskManager.enums.TaskPriority;
import taskManager.enums.TaskCategory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiTask extends AbstractTask {

    private static String type = "MULTI";

    public MultiTask(String type, TaskCategory taskCategory, TaskPriority taskPriority, String description, String deadline) {
        super(type, taskCategory, taskPriority, description, deadline);
        this.date = new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    @Override
    public void executed() {
        System.out.println("MULTI task is executed");
    }
}
