import castlesit.core.pp.model.User;
import castlesit.core.pp.service.UserService;
import castlesit.core.pp.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();
    private final String testName = "Big";
    private final String testLastName = "Boy";
    private final byte testAge = 50;

    @Test
    public void dropUsersTable() {
        executeTest(() -> {
            userService.dropUsersTable();
            userService.dropUsersTable();
        }, "При тестировании удаления таблицы произошло исключение");
    }

    @Test
    public void createUsersTable() {
        executeTest(() -> {
            userService.dropUsersTable();
            userService.createUsersTable();
        }, "При тестировании создания таблицы пользователей произошло исключение");
    }

    @Test
    public void saveUser() {
        executeTest(() -> {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);

            User user = userService.getAllUsers().get(0);

            Assert.assertEquals("Имя пользователя не совпадает", testName, user.getName());
            Assert.assertEquals("Фамилия пользователя не совпадает", testLastName, user.getLastName());
            Assert.assertEquals("Возраст пользователя не совпадает", Optional.of(testAge), user.getAge());
        }, "Во время тестирования сохранения пользователя произошло исключение");
    }

    @Test
    public void removeUserById() {
        executeTest(() -> {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.removeUserById(1L);
        }, "При тестировании удаления пользователя по id произошло исключение");
    }

    @Test
    public void getAllUsers() {
        executeTest(() -> {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            List<User> userList = userService.getAllUsers();

            Assert.assertEquals("Неверное количество пользователей в таблице", 1, userList.size());
        }, "При попытке достать всех пользователей из базы данных произошло исключение");
    }

    @Test
    public void cleanUsersTable() {
        executeTest(() -> {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.cleanUsersTable();

            Assert.assertEquals("Таблица пользователей не очищена", 0, userService.getAllUsers().size());
        }, "При тестировании очистки таблицы пользователей произошло исключение");
    }

    private void executeTest(Runnable testAction, String errorMessage) {
        try {
            testAction.run();
        } catch (Exception e) {
            Assert.fail(errorMessage + "\n" + e.getMessage());
        }
    }
}
