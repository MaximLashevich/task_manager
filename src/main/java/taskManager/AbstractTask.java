package taskManager;

abstract class AbstractTask implements Taskable {

    public AbstractTask abstractTask;
    private static String type;
    private static String category;
    private static String priority;
    private static String description;
    private static String deadline;
    protected static boolean done;

    public AbstractTask(String type, String category, String priority, String description, String deadline) {
        this.type = type;
        this.category = category;
        this.priority = priority;
        this.description = description;
        this.deadline = deadline;
        this.done = false;
    }

    public static void setType(String type) {
        AbstractTask.type = type;
    }

    public static String getType() {
        return AbstractTask.type;
    }

    public static void setPriority(String priority) {
        AbstractTask.priority = priority;
    }

    public static String getPriority() {
        return AbstractTask.priority;
    }

    public static void setCategory(String category) {
        AbstractTask.category = category;
    }

    public static String getCategory() {
        return AbstractTask.category;
    }

    public static boolean setDoneStatus(boolean done) {
        return AbstractTask.done = done;
    }

    public static boolean getDoneStatus() {
        return AbstractTask.done;
    }

    @Override
    public void print() {
        String typ = "Task Type: " + AbstractTask.type;
        String cat = "Task Category: " + AbstractTask.category;
        String prior = "Task Priority: " + AbstractTask.priority;
        String desc = "Task Description: " + AbstractTask.description;
        String deadl = "Task Deadline: " + AbstractTask.deadline;
        String d;
        if (AbstractTask.done == true) {
            d = "This Task is Completed";
        } else {
            d = "This Task is NOT Completed";
        }
        String concat = "\n" + "\n" + typ + "\n" + cat + "\n" + prior + "\n" + desc + "\n" + deadl + "\n" + d;
        System.out.println(concat);
    }

    @Override
    public String toString() {
        String brief = "Task's description: " + AbstractTask.description + "; Deadline: " + AbstractTask.deadline;
        return brief;
    }
}
