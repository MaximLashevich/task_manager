package taskManager;

import java.util.Scanner;

/**
 * Предметная область: планировщик задач.
 * Требования:
 * 1. Наличие иерархии, отражающей модель "Задача" (интерфейс, абстрактный класс, несколько классов-наследников,
 * имеющих разные особенности). Например: одноразовая задача, повторяемая задача.
 * 2. Минимальные характеристики задачи: название, категория, приоритет, дата выполнения (строки).
 * 3. Корректно использовать инкапсуляцию
 * 4. Клиентский код, в котором создаются задачи разных типов.
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
        System.out.println("Enter task's Category: work or home");
        String category = scanner.nextLine();
        System.out.println("Enter task's Priority from most to least important: 1, 2 or 3");
        String priority = scanner.nextLine();
        System.out.println("Enter task's Description:");
        String description = scanner.nextLine();
        System.out.println("Enter task's Deadline:");
        String deadline = scanner.nextLine();
        if (type.equalsIgnoreCase("single task")) {
            SingleTask singleTask1 = new SingleTask(type, category, priority, description, deadline);
            singleTask1.print();
            singleTask1.setDoneStatus(true);
            singleTask1.print();
            singleTask1.setType("multiple task");
            System.out.println();
            System.out.println(singleTask1.getType());
        } else if (type.equalsIgnoreCase("multiple task")) {
            MultiTask multiTask1 = new MultiTask(type, category, priority, description, deadline);
            multiTask1.print();
            multiTask1.setDoneStatus(true);
            multiTask1.print();
        } else {
            System.out.println("Inappropriate task's type entered. Please restart program.");
        }
    }
}
