package taskManager.util.Repository;

import taskManager.exception.NotUniqueDescriptionException;
import taskManager.model.AbstractTask;

public interface Repositable {
    void save(AbstractTask abstractTask) throws NotUniqueDescriptionException;
}
