package DAOimplementationClasses;

import main.java.DAO.UserDao;
import main.java.org.solvd.tableClasses.User;

import java.sql.SQLException;

public class UserDaoImpl {

    public static void main(String[] args) throws SQLException {
        User user1 = new User(1, "Nick", "Jonson", 23, 1);
        User user2 = new User(2, "William", "Goldfish", 31, 1);
        User user3 = new User(3, "Alex", "Neil", 29, 1);
        User user4 = new User(4, "Jerry", "Olbright", 25, 2);
        User user5 = new User(5, "Julie", "Bitton", 26, 2);
        User user6 = new User(6, "Adam", "Williams", 20, 2);
        UserDao userDao = new UserDao();

        //  userDao.insert(user6);
        //   userDao.update(new User(6, "Adam", "James", 25, 2));
        //  System.out.println(userDao.getEntityById(3));
        // System.out.println(userDao.getAll());
        // userDao.delete(user6);
    }
}
