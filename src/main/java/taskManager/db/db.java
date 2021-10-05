package taskManager.db;

import taskManager.exception.DoubleTaskExceptionId;
import taskManager.model.AbstractTask;
import taskManager.util.DataStoringUtil;

import java.util.Map;

public final class db {
    private static final Map<Integer, AbstractTask> MAP = (Map<Integer, AbstractTask>) DataStoringUtil.load();

    public static void save(AbstractTask abstractTask) throws DoubleTaskExceptionId {
        if (MAP.containsKey(abstractTask.getId())) {
            throw new DoubleTaskExceptionId(abstractTask.getId());
        }
        MAP.put(abstractTask.getId(), abstractTask);
    }

    public static AbstractTask get(Integer id) {
        return MAP.get(id);
    }

    public void save() {
        DataStoringUtil.save(MAP);
    }
}
