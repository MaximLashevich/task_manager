package taskManager.util.Service;

import taskManager.model.AbstractTask;

import java.util.Optional;
import java.util.stream.Stream;

public interface TaskService {
    void save(AbstractTask abstractTask);

    Optional<Stream<AbstractTask>> get(Integer id);
}
