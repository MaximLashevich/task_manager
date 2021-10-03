package taskManager.models;

import lombok.*;
import taskManager.enums.TaskCategory;
import taskManager.interfaces.Printable;
import taskManager.enums.TaskPriority;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class AbstractTask implements Printable {

    @NonNull
    protected String date;
    protected boolean done;
    private String type;
    private TaskCategory taskCategory;
    private TaskPriority taskPriority;
    private String description;
    private String deadline;

    public AbstractTask(String type, TaskCategory taskCategory, TaskPriority taskPriority, String description,
                        String deadline) {
        this.type = type;
        this.taskPriority = taskPriority;
        this.description = description;
        this.deadline = deadline;
        this.done = false;
        this.taskCategory = taskCategory;
        this.date = new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    public String setType(String type) {
        return this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskPriority getPriority() {
        return this.taskPriority;
    }

    public void setCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public TaskCategory getCategory() {
        return this.taskCategory;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String setDeadline(String deadline) {
        return this.deadline = deadline;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public boolean setDoneStatus(boolean done) {
        return this.done = done;
    }

    public boolean getDoneStatus() {
        return this.done;
    }

    public String getDate() { return this.date; }

    @Override
    public void print() {
        String dat = "Date: " + this.date;
        String typ = "Task Type: " + this.type;
        String cat = "Task Category: " + this.taskCategory;
        String prior = "Task Priority: " + this.taskPriority;
        String desc = "Task Description: " + this.description;
        String deadl = "Task Deadline: " + this.deadline;
        String d;
        if (this.done) {
            d = "This Task is Completed";
        } else {
            d = "This Task is NOT Completed";
        }
        String concat = "\n" + "\n" + dat + "\n" + typ + "\n" + cat + "\n" + prior + "\n" + desc +
                "\n" + deadl + "\n" + d;
        System.out.println(concat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractTask)) {
            return false;
        }
        AbstractTask that = (AbstractTask) o;
        return isDone() == that.isDone() && getType().equals(that.getType()) && getTaskCategory() == that.getTaskCategory() && getTaskPriority() == that.getTaskPriority() && getDescription().equals(that.getDescription()) && getDeadline().equals(that.getDeadline()) && getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getTaskCategory(), getTaskPriority(), getDescription(), getDeadline(), getDate(), getDoneStatus());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractTask{");
        sb.append("date='").append(date).append('\'');
        sb.append(", done=").append(done);
        sb.append(", type='").append(type).append('\'');
        sb.append(", taskCategory=").append(taskCategory);
        sb.append(", taskPriority=").append(taskPriority);
        sb.append(", description='").append(description).append('\'');
        sb.append(", deadline='").append(deadline).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public abstract void exec();
}