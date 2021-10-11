package taskManager.util;

import taskManager.model.AbstractTask;

import java.util.Optional;
import java.util.stream.Stream;

public class DataRepositoryUtil implements Gettable, Repositable {
    @Override
    public void save(AbstractTask abstractTask) {
        DataManagementUtil.save(abstractTask);
    }

    @Override
    public Optional<Optional<Stream<AbstractTask>>> get(Integer id) {
        return Optional.ofNullable(Optional.ofNullable(DataManagementUtil.get(id)));
    }
}
