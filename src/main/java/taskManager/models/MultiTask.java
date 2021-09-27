package taskManager.models;

import taskManager.enums.TaskPriority;
import taskManager.enums.TaskCategory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiTask extends AbstractTask implements Comparable<AbstractTask>{

    private static String type = "MULTI";

    public MultiTask(String type, TaskCategory taskCategory, TaskPriority taskPriority, String description, String deadline) {
        super(type, taskCategory, taskPriority, description, deadline);
        this.date = new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    @Override
    public int compareTo(AbstractTask abstractTask) {
        int result  = this.date.compareTo(abstractTask.date);
        System.out.println(result);
        return result;
    }

    @Override
    public void exec() {
        System.out.println("MULTI task is executed");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("date='").append(date).append('\'');
        sb.append(", done=").append(done);
        sb.append(", type='").append(type).append('\'');
        sb.append(", taskCategory=").append(getCategory());
        sb.append(", taskPriority=").append(getPriority());
        sb.append(", description='").append(getDescription()).append('\'');
        sb.append(", deadline='").append(getDeadline()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
