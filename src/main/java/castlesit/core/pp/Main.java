package castlesit.core.pp;

import castlesit.core.pp.dao.UserDao;
import castlesit.core.pp.dao.UserDaoJDBCImpl;
import castlesit.core.pp.model.User;
import castlesit.core.pp.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //Util util = new Util();
        //util.getConnection();
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 11);
        userDao.saveUser("Name2", "LastName2", (byte) 22);
        userDao.saveUser("Name3", "LastName3", (byte) 33);
        userDao.saveUser("Name4", "LastName4", (byte) 44);

        userDao.removeUserById(3);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();


    }
}
