package main.java.DAO;

import main.java.org.solvd.tableClasses.MyConnection;
import main.java.org.solvd.tableClasses.SavedDestinationPoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SavedDestinationPointDao extends MySqlDao implements IBaseDao<SavedDestinationPoint> {
    private List<SavedDestinationPoint> savedDestinationPoints;
    Connection connection;
    private final static String GET_DESTINATION_POINT_BY_ID = "SELECT * FROM SavedDestinationPoints WHERE idSavedDestinationPoints = ";
    private final static String GET_ALL_DESTINATION_POINTS = "SELECT * FROM SavedDestinationPoints";
    private final static String INSERT_DESTINATION_POINT = "INSERT INTO SavedDestinationPoints (idSavedDestinationPoints, Address, Orders_idOrders) " +
            "VALUES (?, ?, ?)";
    private final static String UPDATE_DESTINATION_POINT = "UPDATE SavedDestinationPoints SET idSavedDestinationPoints = ?, " +
            "Address = ?, Orders_idOrders = ? WHERE idSavedDestinationPoints = ";
    private final static String DELETE_DESTINATION_POINT = "DELETE FROM SavedDestinationPoints WHERE idSavedDestinationPoints = ";

    public SavedDestinationPointDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }
    @Override
    public Optional<SavedDestinationPoint> getEntityById(int id) throws SQLException {
        SavedDestinationPoint savedDestinationPoint = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_DESTINATION_POINT_BY_ID + id);
        while (rs.next()) {
            savedDestinationPoint = (new SavedDestinationPoint(rs.getInt("idSavedDestinationPoints"), rs.getString("Address"),
                    rs.getInt("Orders_idOrders")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(savedDestinationPoint);
    }

    @Override
    public List<SavedDestinationPoint> getAll() {
        savedDestinationPoints = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_DESTINATION_POINTS);
            while (rs.next()) {
                savedDestinationPoints.add(new SavedDestinationPoint(rs.getInt("idSavedDestinationPoints"), rs.getString("Address"),
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
        return savedDestinationPoints;
    }

    @Override
    public int insert(SavedDestinationPoint savedDestinationPoint) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_DESTINATION_POINT);

        ps.setInt(1, savedDestinationPoint.getId());
        ps.setString(2, savedDestinationPoint.getAddress());
        ps.setInt(3, savedDestinationPoint.getIdOrder());

        int result = ps.executeUpdate();
        System.out.println("Destination point with id " + savedDestinationPoint.getId() + " was created in DB with following details: "
                + savedDestinationPoint);

        try {
            savedDestinationPoints.add(savedDestinationPoint);
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
    public int update(SavedDestinationPoint savedDestinationPoint) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_DESTINATION_POINT + savedDestinationPoint.getId());

        ps.setInt(1, savedDestinationPoint.getId());
        ps.setString(2, savedDestinationPoint.getAddress());
        ps.setInt(3, savedDestinationPoint.getIdOrder());

        int result = ps.executeUpdate();
        System.out.println("Destination point with id " + savedDestinationPoint.getId() +
                " was updated in DB with following details: " + savedDestinationPoint);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(SavedDestinationPoint savedDestinationPoint) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_DESTINATION_POINT + savedDestinationPoint.getId());
            System.out.println("Destination point with id " + savedDestinationPoint.getId() + " was removed from the DB");
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
