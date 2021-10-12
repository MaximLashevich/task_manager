package taskManager.enumeration;

public enum TaskPriority {
    HIGH,
    MEDIUM,
    LOW;

    public static boolean priorityValidate(String value) {
        for (TaskPriority taskPriority : TaskPriority.values()) {
            if (taskPriority.toString().equalsIgnoreCase(value)) {
                return true;
            }
        }
        System.out.println("Inappropriate task's Priority entered. Please restart program.");
        return false;
    }

    public static TaskPriority findPriorityValue(String value) {
        TaskPriority match = HIGH;
        for (TaskPriority taskPriority : TaskPriority.values()) {
            if (taskPriority.toString().equalsIgnoreCase(value)) {
                match = taskPriority;
            }
        }
        return match;
    }
}
