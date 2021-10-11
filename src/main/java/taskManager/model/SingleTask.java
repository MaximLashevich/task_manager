package taskManager.model;

import taskManager.enums.TaskCategory;
import taskManager.enums.TaskPriority;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleTask extends AbstractTask {

    private static String reminder;

    public SingleTask(String reminder, String type, TaskCategory taskCategory, TaskPriority taskPriority, String description, String deadline) {
        super(type, taskCategory, taskPriority, description, deadline);
        this.reminder = reminder;
        this.date = new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    @Override
    public void executed() {
        System.out.println("SINGLE task is being executed");
    }

    @Override
    public String toString() {
        String template = "\n\nCreated: %s\nTask ID: %d\nTask Type: %s\nTask Category: %s\nTask Priority: %s\nKey-word reminder: %s\nTask Description: %s\nTask Deadline: %s\n";
        String result = String.format(template, getDate(), getId(), getType(), getCategory(), getPriority(), reminder, getDescription(), getDeadline());
        result += done ? "This task IS COMPLETED\n" : "This task IS NOT COMPLETED\n";
        return result;
    }
}
