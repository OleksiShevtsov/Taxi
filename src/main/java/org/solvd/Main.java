package org.solvd;

import DAO.PhoneNumberDao;
import DAO.UserDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       MyConnection myConnection = new MyConnection();
//       myConnection.getConnection();
        UserDao userDao = new UserDao();
       // System.out.println(userDao.getEntityById(1));
//        List<User> list = userDao.getAll();
//        for (User e : list) {
//            System.out.println(e);
//        }
       // userDao.insert(new User(8, "Ben", "Mladich", 43, 1));
       // userDao.update(new User(8, "Ben", "Bladich", 48, 1));
       // userDao.delete(new User(8));

        PhoneNumberDao phoneNumberDao = new PhoneNumberDao();
        phoneNumberDao.insert(new PhoneNumber(2, "0971230567", 7));

    }
}