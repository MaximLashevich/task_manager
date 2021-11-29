package taskManager.util;

import taskManager.exception.TaskNotFoundException;
import taskManager.model.AbstractTask;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

public class DataSortUtil {

    public static void printAllTasks() {
        DataManagementUtil.getTasks().forEach(System.out::println);
    }

    public static void printTasksByCategory(String cat) throws TaskNotFoundException {
        try {
            DataManagementUtil.getTasks()
                    .stream()
                    .filter(task -> task.getCategory().toString()
                            .equalsIgnoreCase(cat))
                    .forEach(System.out::println);
        } catch (TaskNotFoundException e) {
            System.out.println(String.format("\nTask with Category %s wasn't loaded. Given Category does not exist or there are no tasks with such category", cat));
        }
    }

    public static void printAllUndoneTasks() throws TaskNotFoundException {
        try {
            DataManagementUtil.getTasks()
                    .stream()
                    .filter(task -> task.getDoneStatus() == false)
                    .forEach(System.out::println);
        } catch (TaskNotFoundException e) {
            System.out.println("\nAll tasks ARE COMPLETED");
        }
    }

    public static void printAllTasksDescriptions() {
        DataManagementUtil.getTasks()
                .stream()
                .map(AbstractTask::getDescription)
                .forEach(System.out::println);
    }

    public static long calculateTasksDaysBeforeDeadline(AbstractTask abstractTask) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String stringDate = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(new Date());
        LocalDate todayDate = LocalDate.parse(stringDate, formatter);
        long daysBeforeDeadline = DAYS.between(todayDate, abstractTask.getDeadline());
        if (daysBeforeDeadline < 0) {
            throw new RuntimeException("This task's deadline has already passed!");
        }
        return daysBeforeDeadline;
    }

    public static void printTasksDaysBeforeDeadline() {
        Map<String, Long> tasksWithDaysBeforeDeadline = new HashMap<>();

        DataManagementUtil.getTasks().forEach(task -> {
            tasksWithDaysBeforeDeadline.put(task.getDescription(), calculateTasksDaysBeforeDeadline(task));
        });

        tasksWithDaysBeforeDeadline.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}

