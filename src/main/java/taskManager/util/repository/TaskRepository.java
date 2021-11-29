package taskManager.util.repository;

import taskManager.exception.NotUniqueDescriptionException;
import taskManager.model.AbstractTask;

public interface TaskRepository {

    void save(AbstractTask abstractTask) throws NotUniqueDescriptionException;

    void get(Integer id);
}
