package DAO;

import org.solvd.Car;
import org.solvd.MyConnection;
import org.solvd.PhoneNumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDao extends MySqlDao implements IBaseDao<Car> {
    private List<Car> cars;
    Connection connection;
    private final static String GET_CAR_BY_ID = "SELECT * FROM Cars WHERE idCars = ";
    private final static String GET_ALL_CARS = "SELECT * FROM Cars";
    private final static String INSERT_CAR = "INSERT INTO Cars (idCars, Model, Users_idUsers, RegistrationNumber, Mileage, Fuel) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_CAR = "UPDATE Cars SET idCars = ?, Model = ?, Users_idUsers = ?, RegistrationNumber =?, " +
            "Mileage = ?, Fuel = ? WHERE idCars = ";
    private final static String DELETE_CAR = "DELETE FROM Cars WHERE idCars = ";

    public CarDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<Car> getEntityById(int id) throws SQLException {
        Car car = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_CAR_BY_ID + id);
        while (rs.next()) {
            car = (new Car(rs.getInt("idCars"), rs.getString("Model"), rs.getInt("Users_idUsers"),
                    rs.getString("RegistrationNumber"), rs.getInt("Mileage"), rs.getString("Fuel")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(car);
    }

    @Override
    public List<Car> getAll() {
        cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_CARS);
            while (rs.next()) {
                cars.add(new Car(rs.getInt("idCars"), rs.getString("Model"), rs.getInt("Users_idUsers"),
                        rs.getString("RegistrationNumber"), rs.getInt("Mileage"), rs.getString("Fuel")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public int insert(Car car) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_CAR);

        ps.setInt(1, car.getId());
        ps.setString(2, car.getModel());
        ps.setInt(3, car.getUserId());
        ps.setString(4, car.getRegistrationNumber());
        ps.setInt(5, car.getMileage());
        ps.setString(6, car.getFuel());

        int result = ps.executeUpdate();
        System.out.println("Car with id " + car.getId() + " was created in DB with following details: " + car);

        try {
            cars.add(car);
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
    public int update(Car car) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_CAR + car.getId());

        ps.setInt(1, car.getId());
        ps.setString(2, car.getModel());
        ps.setInt(3, car.getUserId());
        ps.setString(4, car.getRegistrationNumber());
        ps.setInt(5, car.getMileage());
        ps.setString(6, car.getFuel());

        int result = ps.executeUpdate();
        System.out.println("Cart with id " + car.getId() + " was updated in DB with following details: " + car);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(Car car) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_CAR + car.getId());
            System.out.println("Car with id " + car.getId() + " was removed from the DB");
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
