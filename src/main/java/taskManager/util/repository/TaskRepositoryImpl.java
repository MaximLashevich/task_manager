package taskManager.util.repository;

import taskManager.exception.NotUniqueDescriptionException;
import taskManager.exception.TaskNotFoundException;
import taskManager.model.AbstractTask;
import taskManager.util.DataManagementUtil;

public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public void save(AbstractTask abstractTask) throws NotUniqueDescriptionException {
        DataManagementUtil.save(abstractTask);
    }

    @Override
    public void get(Integer id) throws TaskNotFoundException {
        DataManagementUtil.get(id);
    }
}
