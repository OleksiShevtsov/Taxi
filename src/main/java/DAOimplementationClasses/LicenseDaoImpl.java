package main.java.DAOimplementationClasses;

import main.java.DAO.LicenseDao;
import main.java.org.solvd.tableClasses.License;

import java.sql.Date;
import java.sql.SQLException;

public class LicenseDaoImpl {

    public static void main(String[] args) throws SQLException {
        License license1 = new License(1, 1456, new Date(123, 11, 22), 1);
        License license2 = new License(2, 5612, new Date(125, 10, 13), 2);
        License license3 = new License(3, 6109, new Date(124, 9, 24), 3);
        License license4 = new License(4, 1602, new Date(123, 8, 14), 4);
        License license5 = new License(5, 3189, new Date(126, 11, 20), 5);
        LicenseDao licenseDao = new LicenseDao();

        //   licenseDao.insert(license5);
        //   licenseDao.update(new License(5, 1602, new Date(123, 12, 14), 14));
        // System.out.println(licenseDao.getEntityById(3));
        //    System.out.println(licenseDao.getAll());
        //    licenseDao.delete(license5);
    }
}
