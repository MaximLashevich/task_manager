package taskManager.util;

import taskManager.model.AbstractTask;

import java.util.Optional;
import java.util.stream.Stream;

public interface Gettable {
    Optional<Optional<Stream<AbstractTask>>> get(Integer id);
}
