package DAOimplementationClasses;

import DAO.CarServiceOrderDao;
import org.solvd.tableClasses.CarServiceOrder;

import java.sql.SQLException;

public class CarServiceOrderDaoImpl {

    public static void main(String[] args) throws SQLException {
        CarServiceOrder serviceOrder1 = new CarServiceOrder(1, "transmission repair", "13-12-2022",
                3400.95, 1, 1);
        CarServiceOrder serviceOrder2 = new CarServiceOrder(2, "varnishing", "03-01-2023",
                2780, 2, 4);
        CarServiceOrder serviceOrder3 = new CarServiceOrder(3, "engine repair", "15-08-2022",
                12365.5, 3, 2);
        CarServiceOrder serviceOrder4 = new CarServiceOrder(4, "chassis repair", "23-10-2022",
                4500, 4, 3);
        CarServiceOrder serviceOrder5 = new CarServiceOrder(5, "transmission repair", "13-11-2022",
                5500.65, 5, 5);
        CarServiceOrderDao carServiceOrderDao = new CarServiceOrderDao();

        //  carServiceOrderDao.insert(serviceOrder5);
        //   carServiceOrderDao.update(new CarServiceOrder(5, "transmission repair", "13-11-2021", 5500.65, 5, 5));
        //     System.out.println(carServiceOrderDao.getEntityById(3));
        //   System.out.println(carServiceOrderDao.getAll());
        // carServiceOrderDao.delete(serviceOrder5);
    }
}
