package DAO;

import org.solvd.tableClasses.MyConnection;
import org.solvd.tableClasses.SavedDeparturePoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SavedDeparturePointDao extends MySqlDao implements IBaseDao<SavedDeparturePoint> {
    private List<SavedDeparturePoint> savedDeparturePoints;
    Connection connection;
    private final static String GET_DEPARTURE_POINT_BY_ID = "SELECT * FROM SavedDeparturePoints WHERE idSavedDeparturePoints = ";
    private final static String GET_ALL_DEPARTURE_POINTS = "SELECT * FROM SavedDeparturePoints";
    private final static String INSERT_DEPARTURE_POINT = "INSERT INTO SavedDeparturePoints (idSavedDeparturePoints, Address, Orders_idOrders) " +
            "VALUES (?, ?, ?)";
    private final static String UPDATE_DEPARTURE_POINT = "UPDATE SavedDeparturePoints SET idSavedDeparturePoints = ?, " +
            "Address = ?, Orders_idOrders = ? WHERE idSavedDeparturePoints = ";
    private final static String DELETE_DEPARTURE_POINT = "DELETE FROM SavedDeparturePoints WHERE idSavedDeparturePoints = ";

    public SavedDeparturePointDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<SavedDeparturePoint> getEntityById(int id) throws SQLException {
        SavedDeparturePoint savedDeparturePoint = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_DEPARTURE_POINT_BY_ID + id);
        while (rs.next()) {
            savedDeparturePoint = (new SavedDeparturePoint(rs.getInt("idSavedDeparturePoints"), rs.getString("Address"),
                    rs.getInt("Orders_idOrders")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(savedDeparturePoint);
    }

    @Override
    public List<SavedDeparturePoint> getAll() {
        savedDeparturePoints = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_DEPARTURE_POINTS);
            while (rs.next()) {
                savedDeparturePoints.add(new SavedDeparturePoint(rs.getInt("idSavedDeparturePoints"), rs.getString("Address"),
                        rs.getInt("Orders_idOrders")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedDeparturePoints;
    }

    @Override
    public int insert(SavedDeparturePoint savedDeparturePoint) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_DEPARTURE_POINT);

        ps.setInt(1, savedDeparturePoint.getId());
        ps.setString(2, savedDeparturePoint.getAddress());
        ps.setInt(3, savedDeparturePoint.getIdOrder());

        int result = ps.executeUpdate();
        System.out.println("Departure point with id " + savedDeparturePoint.getId() + " was created in DB with following details: "
                + savedDeparturePoint);

        try {
            savedDeparturePoints.add(savedDeparturePoint);
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
    public int update(SavedDeparturePoint savedDeparturePoint) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_DEPARTURE_POINT + savedDeparturePoint.getId());

        ps.setInt(1, savedDeparturePoint.getId());
        ps.setString(2, savedDeparturePoint.getAddress());
        ps.setInt(3, savedDeparturePoint.getIdOrder());

        int result = ps.executeUpdate();
        System.out.println("Departure point with id " + savedDeparturePoint.getId() +
                " was updated in DB with following details: " + savedDeparturePoint);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(SavedDeparturePoint savedDeparturePoint) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_DEPARTURE_POINT + savedDeparturePoint.getId());
            System.out.println("Departure point with id " + savedDeparturePoint.getId() + " was removed from the DB");
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
