package DAO;

import org.solvd.Car;
import org.solvd.CarService;
import org.solvd.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarServiceDao extends MySqlDao implements IBaseDao<CarService> {
    private List<CarService> carServices;
    Connection connection;
    private final static String GET_CAR_SERVICE_BY_ID = "SELECT * FROM CarService WHERE idCarService = ";
    private final static String GET_ALL_CAR_SERVICES = "SELECT * FROM CarService";
    private final static String INSERT_CAR_SERVICE = "INSERT INTO CarService (idCarService, Name, Address) " + "VALUES (?, ?, ?)";
    private final static String UPDATE_CAR_SERVICE = "UPDATE CarService SET idCarService = ?, Name = ?, Address = ? WHERE idCarService = ";
    private final static String DELETE_CAR_SERVICE = "DELETE FROM CarService WHERE idCarService = ";

    public CarServiceDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<CarService> getEntityById(int id) throws SQLException {
        CarService carService = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_CAR_SERVICE_BY_ID + id);
        while (rs.next()) {
            carService = (new CarService(rs.getInt("idCarService"), rs.getString("Name"),
                    rs.getString("Address")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(carService);
    }

    @Override
    public List<CarService> getAll() {
        carServices = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_CAR_SERVICES);
            while (rs.next()) {
                carServices.add(new CarService(rs.getInt("idCarService"), rs.getString("Name"),
                        rs.getString("Address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carServices;
    }

    @Override
    public int insert(CarService carService) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_CAR_SERVICE);

        ps.setInt(1, carService.getId());
        ps.setString(2, carService.getName());
        ps.setString(3, carService.getAddress());

        int result = ps.executeUpdate();
        System.out.println("Car with id " + carService.getId() + " was created in DB with following details: " + carService);

        try {
            carServices.add(carService);
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
    public int update(CarService carService) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_SERVICE + carService.getId());

        ps.setInt(1, carService.getId());
        ps.setString(2, carService.getName());
        ps.setString(3, carService.getAddress());

        int result = ps.executeUpdate();
        System.out.println("Cart with id " + carService.getId() + " was updated in DB with following details: " + carService);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(CarService carService) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_CAR_SERVICE + carService.getId());
            System.out.println("Car with id " + carService.getId() + " was removed from the DB");
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
