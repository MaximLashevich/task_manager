package taskManager;

import taskManager.enums.TaskCategory;
import taskManager.enums.TaskPriority;
import taskManager.models.AbstractTask;
import taskManager.models.MultiTask;
import taskManager.models.SingleTask;
import taskManager.models.User;

import java.util.*;

/**
 * Предметная область: планировщик задач.
 * Требования:
 * 1. Наличие иерархии, отражающей модель "Задача" (интерфейс, абстрактный класс, несколько классов-наследников,
 * имеющих разные особенности). Например: одноразовая задача, повторяемая задача.
 * 2. Минимальные характеристики задачи: название, категория, приоритет, дата выполнения (строки).
 * 3. Корректно использовать инкапсуляцию
 * 4. Клиентский код, в котором создаются задачи разных типов.
 * <p>
 * Внутренние классы. Перечисляемые типы. Дженерики
 * 1. Изменить поля задачи "категория" и "приоритет" на перечисляемый тип (использовать поля в enum)
 * 2. Добавить модель "Пользователь", создание которого происходит через builder
 * 3. Добавить пользователю поле "id" и использовать возможность параметризации для этого поля. Должен быть
 * также параметризован конструктор, геттер и сеттер. Создать 2 реализации, параметризованные разными типами
 * (например, String и Integer).
 * <p>
 * 1. Добавить список задач. Пользовать может добавить задачу в список, просмотреть весь список.
 * 2. Задача должна переопределять методы hashCode и equals, имплементить интерфейс Comparable
 * (переопределить метод compareTo).
 * 3. Пользователь может отсортировать задачи.
 *
 * @author Maksim Lashevich
 * @version 1
 */

public class App {
    public static void main(String[] args) {
        List<AbstractTask> tasks = new LinkedList<>();
        System.out.println("Please type any symbol to begin entering new tasks or type \"cancel\" to stop input");
        Scanner scanner = new Scanner(System.in);
        String proceed = scanner.nextLine();
        while (proceed.compareToIgnoreCase("cancel") != 0) {
            System.out.println("Enter task's Type: SINGLE or MULTI or type \"cancel\" to stop input");
            String type = scanner.nextLine();
            if (type.compareToIgnoreCase("cancel") != 0) {
                System.out.println("Enter task's Category: WORK, HOME, FAMILY or FRIENDS");
                String category = scanner.nextLine();
                if (TaskCategory.categoryValidate(category) == false) {
                    break;
                }
                System.out.println("Enter task's Priority: HIGH, MEDIUM or LOW");
                String priority = scanner.nextLine();
                if (TaskPriority.priorityValidate(priority) == false) {
                    break;
                }
                System.out.println("Enter task's Description:");
                String description = scanner.nextLine();
                System.out.println("Enter task's Deadline:");
                String deadline = scanner.nextLine();
                tasks.add(taskCreate(type, category, priority, description, deadline));
            } else{
                break;
            }
        }
        tasks.forEach(AbstractTask::print);

        if (tasks.size() > 1) {
            boolean equals = tasks.get(0).equals(tasks.get(1));
        }

        tasks.forEach(AbstractTask::hashCode);

        User<String> builtUser1 = new User.Builder<String>().name("Vasya").age(35).id("1").build();
        User<Integer> builtUser2 = new User.Builder<Integer>().name("Petya").age(25).id(2).build();
        User<String> user3 = new User<>("Tom", 28, "3");
        User<Integer> user4 = new User<>("Bob", 40, 4);
    }

    public static AbstractTask taskCreate(String type, String category, String priority, String description, String deadline){
        if (type.equalsIgnoreCase("MULTI")) {
            AbstractTask task =
                    new MultiTask(type, TaskCategory.findCategoryValue(category),
                            TaskPriority.findPriorityValue(priority), description, deadline);
            return task;
        } else {
            AbstractTask task =
                    new SingleTask(type, TaskCategory.findCategoryValue(category),
                            TaskPriority.findPriorityValue(priority), description, deadline);
            return task;
        }
    }

}
