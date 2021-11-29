package taskManager.util;

import taskManager.exception.NotUniqueDescriptionException;
import taskManager.exception.TaskNotFoundException;
import taskManager.model.AbstractTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public final class DataManagementUtil {

    private static List<AbstractTask> tasks = new ArrayList<>();

    public static void save(AbstractTask abstractTask) throws NotUniqueDescriptionException {

        boolean taskWithDescriptionExists = tasks.stream()
                .anyMatch(task -> task.getDescription().equals(abstractTask.getDescription()));
        if (taskWithDescriptionExists) {
            throw new NotUniqueDescriptionException(abstractTask.getDescription());
        }

        abstractTask.setId(tasks.toArray().length + 1);
        tasks.add(abstractTask);
    }

    public static void remove(Integer id) {
        tasks.forEach(task -> {
            if (task.getId() == id) {
                tasks.remove(task);
            }
        });
    }

    public static void get(Integer id) throws TaskNotFoundException { // Optional на всякий случай, если задача будет null
        Optional<AbstractTask> getTask = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
        if (getTask.isPresent()) {
            System.out.println(getTask.get());
        } else{
            throw new TaskNotFoundException(id);
        }
    }

    public static List<AbstractTask> getTasks() {
        return tasks;
    }

    public static void save() {
        DataSerializingUtil.save(tasks);
    }

    public static void load() {
        tasks = (ArrayList<AbstractTask>) DataSerializingUtil.load();
    }
}
