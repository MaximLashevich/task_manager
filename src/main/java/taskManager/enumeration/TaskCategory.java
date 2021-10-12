package taskManager.enumeration;

public enum TaskCategory {
    WORK,
    HOME,
    FAMILY,
    FRIENDS;

    public static boolean categoryValidate(String value) {
        for (TaskCategory taskCategory : TaskCategory.values()) {
            if (taskCategory.toString().equalsIgnoreCase(value)) {
                return true;
            }
        }
        System.out.println("Inappropriate task's Category entered. Please restart program.");
        return false;
    }

    public static TaskCategory findCategoryValue(String value) {
        TaskCategory match = WORK;
        for (TaskCategory taskCategory : TaskCategory.values()) {
            if (taskCategory.toString().equalsIgnoreCase(value)) {
                match = taskCategory;
            }
        }
        return match;
    }


}

