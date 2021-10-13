package taskManager.util.Repository;

import taskManager.exception.NotUniqueDescriptionException;
import taskManager.model.AbstractTask;
import taskManager.util.DataManagementUtil;

import java.util.Optional;
import java.util.stream.Stream;

public class DataRepositoryUtilImpl implements Repositable {
    @Override
    public void save(AbstractTask abstractTask) throws NotUniqueDescriptionException {
        DataManagementUtil.save(abstractTask);
    }



    public static Optional<Optional<Stream<AbstractTask>>> get(Integer id) {
        return Optional.of(Optional.ofNullable(DataManagementUtil.get(id)));
    }
}
