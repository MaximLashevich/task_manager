package taskManager.model;

import taskManager.enums.TaskCategory;
import taskManager.enums.TaskPriority;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleTask extends AbstractTask {

    private static String type = "SINGLE";


    public SingleTask(String type, TaskCategory taskCategory, TaskPriority taskPriority, String description, String deadline) {
        super(type, taskCategory, taskPriority, description, deadline);
        this.date = new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    @Override
    public void executed() {
        System.out.println("SINGLE task is being executed");
    }
}
