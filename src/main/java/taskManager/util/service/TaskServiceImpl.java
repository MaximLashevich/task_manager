package taskManager.util.service;

import taskManager.exception.NotUniqueDescriptionException;
import taskManager.exception.TaskNotFoundException;
import taskManager.model.AbstractTask;
import taskManager.util.repository.TaskRepositoryImpl;

public class TaskServiceImpl implements TaskService {

    private TaskRepositoryImpl taskRepositoryImpl;

    public TaskServiceImpl(TaskRepositoryImpl taskRepositoryImpl){
        this.taskRepositoryImpl = taskRepositoryImpl;
    }

    @Override
    public void save(AbstractTask abstractTask) {
        try {
            taskRepositoryImpl.save(abstractTask);
            System.out.println(String.format("\nTask: \"%s\" \nis successfully saved", abstractTask.getDescription()));
        } catch (NotUniqueDescriptionException e) {
            System.out.println(String.format("\nTask: \"%s\" \nis not saved as NOT unique", abstractTask.getDescription()));
        }
    }

    @Override
    public void get(Integer id) {
        try {
            taskRepositoryImpl.get(id);
            System.out.println(String.format("\nTask with ID %d is successfully displayed", id));
        } catch (TaskNotFoundException e) {
            System.out.println(String.format("\nTask is not loaded as given ID%d does NOT exist", id));
        }
    }

}
