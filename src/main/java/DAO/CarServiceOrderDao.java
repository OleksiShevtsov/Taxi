package main.java.DAO;

import main.java.org.solvd.tableClasses.CarServiceOrder;
import main.java.org.solvd.tableClasses.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarServiceOrderDao extends MySqlDao implements IBaseDao<CarServiceOrder> {
    private List<CarServiceOrder> carServiceOrders;
    Connection connection;
    private final static String GET_CAR_SERVICE_ORDER_BY_ID = "SELECT * FROM CarServiceOrders WHERE idCarServiceOrders = ";
    private final static String GET_ALL_CAR_SERVICE_ORDERS = "SELECT * FROM CarServiceOrders";
    private final static String INSERT_CAR_SERVICE_ORDER = "INSERT INTO CarServiceOrders " +
            "(idCarServiceOrders, ServiceName, ServiceDate, Price, Cars_idCars, CarService_idCarService) " + "VALUES (?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_CAR_SERVICE_ORDER = "UPDATE CarServiceOrders SET idCarServiceOrders = ?, ServiceName = ?, " +
            "ServiceDate = ?, Price = ?, Cars_idCars =?, CarService_idCarService = ? WHERE idCarServiceOrders = ";
    private final static String DELETE_CAR_SERVICE_ORDER = "DELETE FROM CarServiceOrders WHERE idCarServiceOrders = ";

    public CarServiceOrderDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<CarServiceOrder> getEntityById(int id) throws SQLException {
        CarServiceOrder carServiceOrder = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_CAR_SERVICE_ORDER_BY_ID + id);
        while (rs.next()) {
            carServiceOrder = (new CarServiceOrder(rs.getInt("idCarServiceOrders"),
                    rs.getString("ServiceName"), rs.getString("ServiceDate"), rs.getDouble("Price"),
                    rs.getInt("Cars_idCars"), rs.getInt("CarService_idCarService")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(carServiceOrder);
    }

    @Override
    public List<CarServiceOrder> getAll() {
        carServiceOrders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_CAR_SERVICE_ORDERS);
            while (rs.next()) {
                carServiceOrders.add(new CarServiceOrder(rs.getInt("idCarServiceOrders"),
                        rs.getString("ServiceName"), rs.getString("ServiceDate"), rs.getDouble("Price"),
                        rs.getInt("Cars_idCars"), rs.getInt("CarService_idCarService")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carServiceOrders;
    }

    @Override
    public int insert(CarServiceOrder carServiceOrder) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_CAR_SERVICE_ORDER);

        ps.setInt(1, carServiceOrder.getId());
        ps.setString(2, carServiceOrder.getServiceName());
        ps.setString(3, carServiceOrder.getServiceDate());
        ps.setDouble(4, carServiceOrder.getPrice());
        ps.setInt(5, carServiceOrder.getIdCar());
        ps.setInt(6, carServiceOrder.getIdCarService());

        int result = ps.executeUpdate();
        System.out.println("Car with id " + carServiceOrder.getId() + " was created in DB with following details: " + carServiceOrder);

        try {
            carServiceOrders.add(carServiceOrder);
        } catch (NullPointerException e) {
            e.getMessage();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(CarServiceOrder carServiceOrder) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_SERVICE_ORDER + carServiceOrder.getId());

        ps.setInt(1, carServiceOrder.getId());
        ps.setString(2, carServiceOrder.getServiceName());
        ps.setString(3, carServiceOrder.getServiceDate());
        ps.setDouble(4, carServiceOrder.getPrice());
        ps.setInt(5, carServiceOrder.getIdCar());
        ps.setInt(6, carServiceOrder.getIdCarService());

        int result = ps.executeUpdate();
        System.out.println("Car service order with id " + carServiceOrder.getId() + " was updated in DB with following details: "
                + carServiceOrder);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(CarServiceOrder carServiceOrder) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_CAR_SERVICE_ORDER + carServiceOrder.getId());
            System.out.println("Car service order with id " + carServiceOrder.getId() + " was removed from the DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
