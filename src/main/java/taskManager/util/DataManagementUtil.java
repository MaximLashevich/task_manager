package taskManager.util;

import taskManager.model.AbstractTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public final class DataManagementUtil {
    private static int lastIndexInDb = 0;
    private static final List<AbstractTask> tasks = (ArrayList<AbstractTask>) DataSerializingUtil.load();

    public static void save(AbstractTask abstractTask) {
        abstractTask.setId(lastIndexInDb++);
        tasks.add(abstractTask);
    }

    public static Stream<AbstractTask> get(Integer id) {
        return tasks.stream()
                .filter(task -> task.getId() == id);

    }

    public void save() {
        DataSerializingUtil.save(tasks);
    }
}
