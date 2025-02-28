package castlesit.core.pp.dao;

import castlesit.core.pp.model.User;

import java.util.List;

//Вот тут вы пишите реализацию основной логики. А далее вызываете эти методы через интерфейс в UserServiceImpl.
//Позже вы поймёте зачем это. Это нужно для работы транзакций. Но пока не запаривайтесь, просто сделайте, чтобы работало.

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
