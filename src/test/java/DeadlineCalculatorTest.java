import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import taskManager.enumeration.TaskCategory;
import taskManager.enumeration.TaskPriority;
import taskManager.model.AbstractTask;
import taskManager.model.MultiTask;
import taskManager.util.DataSortUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeadlineCalculatorTest {
    @ParameterizedTest
    @MethodSource("pricesSource")
    void testDaysBeforeDeadline(String inputDeadline, long expectedDaysBeforeDeadline) {
        // given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        AbstractTask abstractTask = MultiTask.builder()
                .type("Multi")
                .taskCategory(TaskCategory.WORK)
                .taskPriority(TaskPriority.HIGH)
                .description("Submit a report")
                .deadline(LocalDate.parse(inputDeadline, formatter))
                .repeatNumber("5")
                .build();

        // when
        long actualDaysBeforeDeadline = DataSortUtil.calculateTasksDaysBeforeDeadline(abstractTask);

        // then
        assertEquals(expectedDaysBeforeDeadline, actualDaysBeforeDeadline); // expectedDaysBeforeDeadline вводим вручную на основании своих расчетов
        assertNotEquals(3000, actualDaysBeforeDeadline);
        assertTrue(actualDaysBeforeDeadline >= 0);
        assertTrue(actualDaysBeforeDeadline <= 365 * 2);
    }

    static Stream<Arguments> pricesSource() {  // Arguments - это провайдер параметров теста JUnit'a
        return Stream.of(
                Arguments.of("30.11.2021", 1),  // дни до дедлайна пересчитать, тк будут меняться каждый день
                Arguments.of("01.12.2021", 2),
                Arguments.of("02.12.2021", 3)  // в данном случае ожидаемая цена = начальная цена - желаемая скидка, тк желаемая скидка меньше сезонной скидки
//              Arguments.of("03.12.2021", 50),  // закомменчено. этот тест зафейлится, тк ожидаемая цена рассчитана неверно, верная будет 7
        );
    }

    @Test
    void testPassedDeadline() {
        // given -> when
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        AbstractTask abstractTask = MultiTask.builder()
                .type("Multi")
                .taskCategory(TaskCategory.HOME)
                .taskPriority(TaskPriority.LOW)
                .description("Water flowers")
                .deadline(LocalDate.parse("28.11.2021", formatter))  // when deadline has already passed
                .repeatNumber("5")
                .build();

        //then
        assertThrows(RuntimeException.class, () ->
                DataSortUtil.calculateTasksDaysBeforeDeadline(abstractTask)
        );
    }

    @ParameterizedTest  // эти тесты метода demo чисто для примера
    @EmptySource
    @NullSource
    @ValueSource(strings = {"SINGLE task is executed", "MULTI task is executed"})
    void demo(String input) {
        System.out.println(input);
    }
}
