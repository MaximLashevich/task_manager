package taskManager.model;

import lombok.Builder;
import taskManager.enumeration.TaskPriority;
import taskManager.enumeration.TaskCategory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MultiTask extends AbstractTask implements Serializable {

    private String repeatNumber;

    @Builder
    public MultiTask(String repeatNumber, String type, TaskCategory taskCategory, TaskPriority taskPriority, String description, LocalDate deadline) {
        super(type, taskCategory, taskPriority, description, deadline);
        this.repeatNumber = repeatNumber;
        this.date = new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    @Override
    public void executed() {
        System.out.println("MULTI task is executed");
    }


    @Override
    public String toString() {
        String template = "\n\nCreated: %s\nTask ID: %d\nTask Type: %s\nTask Category: %s\nTask Priority: %s\nTimes to repeat: %s\nTask Description: %s\nTask Deadline: %s\n";
        String result = String.format(template, getDate(), getId(), getType(), getCategory(), getPriority(), repeatNumber, getDescription(), getDeadline());
        result += done ? "This task IS COMPLETED\n" : "This task IS NOT COMPLETED\n";
        return result;
    }
}