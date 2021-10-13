package taskManager.util.Service;

import lombok.AllArgsConstructor;
import taskManager.exception.NotUniqueDescriptionException;
import taskManager.exception.TaskNotFoundException;
import taskManager.model.AbstractTask;
import taskManager.util.Repository.DataRepositoryUtilImpl;

import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor

public class TaskServiceUtilImpl implements TaskService {

    private DataRepositoryUtilImpl dataRepositoryUtilImpl;

    @Override
    public void save(AbstractTask abstractTask) {
        try {
            dataRepositoryUtilImpl.save(abstractTask);
            System.out.println(String.format("Task %s was saved.", abstractTask.getDescription()));
        } catch (NotUniqueDescriptionException e) {
            System.out.println(String.format("Task %s wasn't saved.", abstractTask.getDescription()));
        }

    }

    @Override
    public Optional<Stream<AbstractTask>> get(Integer id) {
        return DataRepositoryUtilImpl.get(id)
                .orElseThrow(() -> new TaskNotFoundException("There's no task with such ID"));
    }

}
