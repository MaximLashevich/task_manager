package taskManager;

import taskManager.models.User;

import java.util.Scanner;
import static taskManager.utils.TaskUtils.createTask;

/**
 * Предметная область: планировщик задач.
 * Требования:
 * 1. Наличие иерархии, отражающей модель "Задача" (интерфейс, абстрактный класс, несколько классов-наследников,
 * имеющих разные особенности). Например: одноразовая задача, повторяемая задача.
 * 2. Минимальные характеристики задачи: название, категория, приоритет, дата выполнения (строки).
 * 3. Корректно использовать инкапсуляцию
 * 4. Клиентский код, в котором создаются задачи разных типов.
 *
 * Внутренние классы. Перечисляемые типы. Дженерики
 * 1. Изменить поля задачи "категория" и "приоритет" на перечисляемый тип (использовать поля в enum)
 * 2. Добавить модель "Пользователь", создание которого происходит через builder
 * 3. Добавить пользователю поле "id" и использовать возможность параметризации для этого поля. Должен быть
 * также параметризован конструктор, геттер и сеттер. Создать 2 реализации, параметризованные разными типами
 * (например, String и Integer).
 *
 * @author Maksim Lashevich
 * @version 1
 */

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter new task");
        System.out.println("Enter task's Type: single task or multiple task");
        String type = scanner.nextLine();
        System.out.println("Enter task's Category: WORK, HOME, FAMILY or FRIENDS");
        String category = scanner.nextLine();
        System.out.println("Enter task's Priority from most to least important: 1, 2 or 3");
        String priority = scanner.nextLine();
        System.out.println("Enter task's Description:");
        String description = scanner.nextLine();
        System.out.println("Enter task's Deadline:");
        String deadline = scanner.nextLine();
        createTask(type, category, priority, description, deadline);

        User<String> builtUser1 = new User.Builder<String>().name("Vasya").age(35).id("1").build();
        User<Integer> builtUser2 = new User.Builder<Integer>().name("Petya").age(25).id(2).build();
        User<String> user3 = new User<>("Tom", 28, "3");
        User<Integer> user4 = new User<>("Bob", 40, 4);

    }




}
