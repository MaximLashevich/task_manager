package taskManager.utils;

import taskManager.enums.TaskCategories;
import taskManager.enums.TaskPriorities;
import taskManager.models.MultiTask;
import taskManager.models.SingleTask;

public class TaskUtils {

    public static void createTask(String type, String category, String priority, String description, String deadline){
        TaskCategories[] catValues = TaskCategories.values();
        TaskPriorities[] priorValues = TaskPriorities.values();
        if (type.equalsIgnoreCase("single task")) {
            for (int i = 0; i < catValues.length; i++) {
                if (category.equalsIgnoreCase(catValues[i].toString())) {
                    for (int j = 0; j < priorValues.length; j++) {
                        if(priority.equalsIgnoreCase(priorValues[j].toString())){
                            SingleTask singleTask = new SingleTask(type, catValues[i], priorValues[j], description, deadline);
                            singleTask.print();
                            break;
                        }
                    }

                } else if (i == (catValues.length - 1)) {
                    System.out.println("Inappropriate task's category entered. Please restart program.");
                }
            }
        } else if (type.equalsIgnoreCase("multiple task")) {
            for (int i = 0; i < catValues.length; i++) {
                if (category.equalsIgnoreCase(catValues[i].toString())) {
                    for (int j = 0; j < priorValues.length; j++) {
                        if (priority.equalsIgnoreCase(priorValues[j].toString())) {
                            MultiTask multiTask = new MultiTask(type, catValues[i], priorValues[j], description, deadline);
                            multiTask.print();
                            break;
                        }
                    }
                } else if (i == (catValues.length - 1)) {
                    System.out.println("Inappropriate task's category entered. Please restart program.");
                }
            }
        } else {
            System.out.println("Inappropriate task's type entered. Please restart program.");
        }
    }
}
