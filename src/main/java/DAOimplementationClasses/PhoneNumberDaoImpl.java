package main.java.DAOimplementationClasses;

import main.java.DAO.PhoneNumberDao;
import main.java.org.solvd.tableClasses.PhoneNumber;

import java.sql.SQLException;

public class PhoneNumberDaoImpl {

    public static void main(String[] args) throws SQLException {
        PhoneNumber phoneNumber1 = new PhoneNumber(1, "0981234567", 3);
        PhoneNumber phoneNumber2 = new PhoneNumber(2, "0349812578", 6);
        PhoneNumber phoneNumber3 = new PhoneNumber(3, "0782789037", 12);
        PhoneNumber phoneNumber4 = new PhoneNumber(4, "0651907156", 2);
        PhoneNumber phoneNumber5 = new PhoneNumber(5, "0961890378", 9);
        PhoneNumberDao phoneNumberDao = new PhoneNumberDao();

     //   phoneNumberDao.insert(phoneNumber5);
     //   phoneNumberDao.update(new PhoneNumber(2, "0349812578", 13));
     //   System.out.println(phoneNumberDao.getEntityById(4));
       // System.out.println(phoneNumberDao.getAll());
       // phoneNumberDao.delete(phoneNumber5);
    }
}
