package taskManager;

import taskManager.enumeration.TaskCategory;
import taskManager.enumeration.TaskPriority;
import taskManager.model.AbstractTask;
import taskManager.model.MultiTask;
import taskManager.model.SingleTask;
import taskManager.model.User;
import taskManager.util.DataManagementUtil;
import taskManager.util.repository.TaskRepositoryImpl;
import taskManager.util.service.TaskServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


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
 * <p>
 * 1. Изменить формат поля "дата" на более подходящий, чем String
 * 2. Выводить пользователю количество времени, которое осталось до дедлайна
 * <p>
 * 1. Cохранять задачи и пользователей между запусками программы.
 *
 * @author Maksim Lashevich
 * @version 1
 */

public class App {

    private static final TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();
    private static final TaskServiceImpl taskServiceImpl = new TaskServiceImpl(taskRepositoryImpl);


    public static void main(String[] args) {

        DataManagementUtil.load();

        AbstractTask abstractTask;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        DataManagementUtil.getTasks().forEach(System.out::println);

        System.out.println("Please type any symbol to begin entering new tasks or type \"cancel\" to stop input");
        Scanner scanner = new Scanner(System.in);
        String proceed = scanner.nextLine();
        while (proceed.compareToIgnoreCase("cancel") != 0) {
            System.out.println("\nEnter new task's Type: SINGLE or MULTI or type \"cancel\" to stop input");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("MULTI")) {
                System.out.println("Enter a number how many times task has to be repeated");
                String repeatNumber = scanner.nextLine();
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
                LocalDate deadlineDate = LocalDate.parse(deadline, formatter);

                abstractTask = multiTaskCreate(repeatNumber, type, category, priority, description, deadlineDate);
                taskServiceImpl.save(abstractTask);


            } else if (type.equalsIgnoreCase("SINGLE")) {
                System.out.println("Enter one key word - a reminder about this task");
                String reminder = scanner.nextLine();
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
                LocalDate deadlineDate = LocalDate.parse(deadline, formatter);

                abstractTask = singleTaskCreate(reminder, type, category, priority, description, deadlineDate);
                taskServiceImpl.save(abstractTask);

            } else {
                break;
            }
        }

        DataManagementUtil.remove(0);
        DataManagementUtil.save();


        User<String> builtUser1 = new User.Builder<String>().name("Vasya").age(35).id("1").build();
        User<Integer> builtUser2 = new User.Builder<Integer>().name("Petya").age(25).id(2).build();
        User<String> user3 = new User<>("Tom", 28, "3");
        User<Integer> user4 = new User<>("Bob", 40, 4);
        builtUser1.toString();
        user4.toString();
    }

    public static AbstractTask multiTaskCreate(String repeatNumber, String type, String category, String priority, String description, LocalDate deadline) {
        return new MultiTask(repeatNumber, type, TaskCategory.findCategoryValue(category),
                TaskPriority.findPriorityValue(priority), description, deadline);
    }

    public static AbstractTask singleTaskCreate(String reminder, String type, String category, String priority, String description, LocalDate deadline) {
        return new SingleTask(reminder, type, TaskCategory.findCategoryValue(category),
                TaskPriority.findPriorityValue(priority), description, deadline);
    }

    public static void taskAdd(AbstractTask abstractTask, List<AbstractTask> tasks){ // Создан аналог этого метода через стрим и записан в папке util
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (abstractTask.getDescription().compareToIgnoreCase(tasks.get(i).getDescription()) == 0) {
                count++;
            }
        }
        if(count == 0){
            tasks.add(abstractTask);
        }
    }
}



