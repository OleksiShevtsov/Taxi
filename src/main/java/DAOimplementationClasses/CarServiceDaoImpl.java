package DAOimplementationClasses;

import DAO.CarServiceDao;
import org.solvd.tableClasses.CarService;

import java.sql.SQLException;

public class CarServiceDaoImpl {

    public static void main(String[] args) throws SQLException {
        CarService service1 = new CarService(1, "Volvo service", "NYC, 15-th str, 12");
        CarService service2 = new CarService(2, "BMW motors", "NJ, Baltimor, Lincoln ave, 1");
        CarService service3 = new CarService(3, "Toyota service", "WDC, Washington ave, 112");
        CarService service4 = new CarService(4, "Opel", "MS, Chicago, Ontario str, 12/9");
        CarService service5 = new CarService(5, "Nissan service co", "VG, Denver, 19-th str, 187");
        CarServiceDao carServiceDao = new CarServiceDao();

        //  carServiceDao.insert(service5);
        //   carServiceDao.update(new CarService(2, "BMW motors", "NJ, Denver, Lincoln ave, 1"));
        //  System.out.println(carServiceDao.getEntityById(4));
        //    System.out.println(carServiceDao.getAll());
//        carServiceDao.delete();
    }
}
