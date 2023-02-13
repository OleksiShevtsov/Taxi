package main.java.DAOimplementationClasses;

import main.java.DAO.OrderDao;
import main.java.org.solvd.tableClasses.Order;

import java.sql.SQLException;

public class OrderDaoImpl {

    public static void main(String[] args) throws SQLException {
        Order order1 = new Order(1, 234.6, "Park lane, 12", "Central station", 1,
                7, 2);
        Order order2 = new Order(2, 157, "15-th str, 125", "River park", 2,
                4, 1);
        Order order3 = new Order(3, 459.5, "Shore bul, 10", "Atlantic port", 3,
                8, 4);
        Order order4 = new Order(4, 212, "Comfort town, 34", "Railway station", 4,
                9, 5);
        Order order5 = new Order(5, 227.6, "23-th str, 112", "Central bul, 25", 5,
                10, 3);
        OrderDao orderDao = new OrderDao();

        //   orderDao.insert(order5);
        //  orderDao.update(new Order(5, 227.6, "23-th str, 112", "Central bul, 25", 5, 10, 3));
        //  System.out.println(orderDao.getEntityById(3));
        //System.out.println(orderDao.getAll());
        //  orderDao.delete(order5);
    }
}
