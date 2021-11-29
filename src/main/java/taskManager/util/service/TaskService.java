package taskManager.util.service;

import taskManager.model.AbstractTask;

public interface TaskService {

    void save(AbstractTask abstractTask);

    void get(Integer id);

}
