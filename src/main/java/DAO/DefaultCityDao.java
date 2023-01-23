package DAO;

import org.solvd.DefaultCity;
import org.solvd.MyConnection;
import org.solvd.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultCityDao extends MySqlDao implements IBaseDao<DefaultCity>{
    private List<DefaultCity> defaultCities;
    Connection connection;
    private final static String GET_CITY_BY_ID = "SELECT * FROM DefaultCity WHERE idDefaultCity = ";
    private final static String GET_ALL_CITIES = "SELECT * FROM DefaultCity";
    private final static String INSERT_CITY = "INSERT INTO DefaultCity (idDefaultCity, Name) VALUES (?, ?)";
    private final static String UPDATE_CITY = "UPDATE DefaultCity SET idDefaultCity = ?, Name = ? WHERE idDefaultCity = ";
    private final static String DELETE_CITY = "DELETE FROM DefaultCity WHERE idDefaultCity = ";

    public DefaultCityDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<DefaultCity> getEntityById(int id) throws SQLException {
        DefaultCity defaultCity = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_CITY_BY_ID + id);
        while (rs.next()) {
            defaultCity = (new DefaultCity(rs.getInt("idStatus"), rs.getString("Name")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(defaultCity);
    }

    @Override
    public List<DefaultCity> getAll() {
        defaultCities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_CITIES);
            while (rs.next()) {
                defaultCities.add(new DefaultCity(rs.getInt("idStatus"), rs.getString("Name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return defaultCities;
    }

    @Override
    public int insert(DefaultCity defaultCity) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_CITY);

        ps.setInt(1, defaultCity.getId());
        ps.setString(2, defaultCity.getName());

        int result = ps.executeUpdate();
        System.out.println("City with id " + defaultCity.getId() + " was created in DB with following details: " + defaultCity);

        try {
            defaultCities.add(defaultCity);
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
    public int update(DefaultCity defaultCity) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_CITY + defaultCity.getId());

        ps.setInt(1, defaultCity.getId());
        ps.setString(2, defaultCity.getName());

        int result = ps.executeUpdate();
        System.out.println("City with id " + defaultCity.getId() + " was updated in DB with following details: " + defaultCity);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(DefaultCity defaultCity) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_CITY + defaultCity.getId());
            System.out.println("City with id " + defaultCity.getId() + " was removed from the DB");
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
