package taskManager;

import taskManager.enums.TaskCategory;
import taskManager.enums.TaskPriority;
import taskManager.model.AbstractTask;
import taskManager.model.MultiTask;
import taskManager.model.SingleTask;
import taskManager.model.User;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
 * <p>
 * 1. Сортировать, фильтровать (выбрать с определенным приоритетом или категорией)
 * 2. Вывести по запросу пользователя названия всех задач (map)
 * 3. Перед добавлением задачи проверить, что задачи с таким именем не существует
 *
 * @author Maksim Lashevich
 * @version 1
 */

public class App {
    public static void main(String[] args) {
        List<AbstractTask> tasks = new ArrayList<>();
        System.out.println("Please type any symbol to begin entering new tasks or type \"cancel\" to stop input");
        Scanner scanner = new Scanner(System.in);
        String proceed = scanner.nextLine();
        while (proceed.compareToIgnoreCase("cancel") != 0) {
            System.out.println("\nEnter new task's Type: SINGLE or MULTI or type \"cancel\" to stop input");
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
                System.out.println("Enter task's Deadline in format \"dd.mm.yyyy\":");
                String deadline = scanner.nextLine();
                tasks.add(taskCreate(type, category, priority, description, deadline));
                System.out.println("Task was successfully added!");
            } else {
                break;
            }
        }

        tasks.forEach(System.out::println);

        tasks.stream()
                .filter(task -> task.getCategory().equals(TaskCategory.WORK))
                .forEach(System.out::println);

        tasks.stream()
                .map(AbstractTask::getDescription)
                .forEach(System.out::println);

        User<String> builtUser1 = new User.Builder<String>().name("Vasya").age(35).id("1").build();
        User<Integer> builtUser2 = new User.Builder<Integer>().name("Petya").age(25).id(2).build();
        User<String> user3 = new User<>("Tom", 28, "3");
        User<Integer> user4 = new User<>("Bob", 40, 4);
        builtUser1.toString();
        user4.toString();
    }

    public static AbstractTask taskCreate(String type, String category, String priority, String description, String deadline) {
        AbstractTask task;
        if (type.equalsIgnoreCase("MULTI")) {
            task = new MultiTask(type, TaskCategory.findCategoryValue(category),
                    TaskPriority.findPriorityValue(priority), description, deadline);
        } else {
            task = new SingleTask(type, TaskCategory.findCategoryValue(category),
                    TaskPriority.findPriorityValue(priority), description, deadline);
        }

        return task;
    }

}
