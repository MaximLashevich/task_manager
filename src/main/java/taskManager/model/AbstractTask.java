package taskManager.model;

import taskManager.enums.TaskCategory;
import taskManager.interfaces.Executable;
import taskManager.enums.TaskPriority;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public abstract class AbstractTask implements Executable, Comparable<AbstractTask> {

    protected String date;
    protected boolean done;
    protected int id;
    private String type;
    private TaskCategory taskCategory;
    private TaskPriority taskPriority;
    private String description;
    private String deadline;

    public AbstractTask(String type, TaskCategory taskCategory, TaskPriority taskPriority, String description,
                        String deadline) {
        this.type = type;
        this.taskCategory = taskCategory;
        this.taskPriority = taskPriority;
        this.description = description;
        this.deadline = deadline;
        this.done = false;
        this.date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());

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

    public int setId(int id) {
        return this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        String template = "\n\nCreated: %s\nTask ID: %d\nTask Type: %s\nTask Category: %s\nTask Priority: %s\nTask Description: %s\nTask Deadline: %s\n";
        System.out.printf(template, date, id, type, taskCategory, taskPriority, description, deadline);
        System.out.println(done ? "This task IS COMPLETED" : "This task IS NOT COMPLETED");
        return template;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractTask)) return false;
        AbstractTask that = (AbstractTask) o;
        return done == that.done && id == that.id && getDate().equals(that.getDate()) && getType().equals(that.getType()) && taskCategory == that.taskCategory && taskPriority == that.taskPriority && getDescription().equals(that.getDescription()) && getDeadline().equals(that.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), done, id, getType(), taskCategory, taskPriority, getDescription(), getDeadline());
    }

    @Override
    public int compareTo(AbstractTask abstractTask) {
        return this.id - abstractTask.id;
    }
}