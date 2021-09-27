package taskManager.models;

import taskManager.enums.TaskCategories;
import taskManager.interfaces.Printable;
import taskManager.enums.TaskPriorities;

public abstract class AbstractTask implements Printable {

    protected boolean done;
    private String type;
    private String category;
    private String priority;
    private String description;
    private String deadline;


    public AbstractTask(String type, TaskCategories categoryConst, TaskPriorities priorityConst, String description, String deadline) {
        this.type = type;
        this.priority = priorityConst.toString();
        this.description = description;
        this.deadline = deadline;
        this.done = false;
        this.category = categoryConst.toString();
        }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public boolean setDoneStatus(boolean done) {
        return this.done = done;
    }

    public boolean getDoneStatus() {
        return this.done;
    }

    @Override
    public void print() {
        String typ = "Task Type: " + this.type;
        String cat = "Task Category: " + this.category;
        String prior = "Task Priority: " + this.priority;
        String desc = "Task Description: " + this.description;
        String deadl = "Task Deadline: " + this.deadline;
        String d;
        if (this.done) {
            d = "This Task is Completed";
        } else {
            d = "This Task is NOT Completed";
        }
        String concat = "\n" + "\n" + typ + "\n" + cat + "\n" + prior + "\n" + desc + "\n" + deadl + "\n" + d;
        System.out.println(concat);
    }


}
