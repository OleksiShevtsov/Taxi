package DAOimplementationClasses;

import DAO.CarDao;
import org.solvd.tableClasses.Car;

import java.sql.SQLException;

public class CarDaoImpl {

    public static void main(String[] args) throws SQLException {
        Car car1 = new Car(1, "Volvo", 1, "FF4321JJ", 120000, "gasoline");
        Car car2 = new Car(2, "Opel", 2, "GE4903NM", 92000, "diesel");
        Car car3 = new Car(3, "BMW", 3, "HF5990AS", 105000, "gasoline");
        Car car4 = new Car(4, "Toyota", 10, "AS4013UU", 125000, "gas");
        Car car5 = new Car(5, "Nissan", 12, "QA0823OO", 98000, "gas");
        CarDao carDao = new CarDao();

        //  carDao.insert(car5);
        //  carDao.update(new Car(4, "Toyota", 13, "AS1097UU", 125000, "gas"));
        //   System.out.println(carDao.getEntityById(4));
        //   System.out.println(carDao.getAll());
//        carDao.delete();
    }
}
