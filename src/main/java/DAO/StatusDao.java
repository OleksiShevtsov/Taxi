package main.java.DAO;

import main.java.org.solvd.tableClasses.MyConnection;
import main.java.org.solvd.tableClasses.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StatusDao extends MySqlDao implements IBaseDao<Status> {
    private List<Status> statuses;
    Connection connection;
    private final static String GET_STATUS_BY_ID = "SELECT * FROM Status WHERE idStatus = ";
    private final static String GET_ALL_STATUSES = "SELECT * FROM Status";
    private final static String INSERT_STATUS = "INSERT INTO Status " + "(idStatus, Name) VALUES (?, ?)";
    private final static String UPDATE_STATUS = "UPDATE Status SET idStatus = ?, Name = ? WHERE idStatus = ";
    private final static String DELETE_STATUS = "DELETE FROM Status WHERE idStatus = ";

    public StatusDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<Status> getEntityById(int id) throws SQLException {
       Status status = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_STATUS_BY_ID + id);
        while (rs.next()) {
            status = (new Status(rs.getInt("idStatus"), rs.getString("Name")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(status);
    }

    @Override
    public List<Status> getAll() {
        statuses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_STATUSES);
            while (rs.next()) {
                statuses.add(new Status(rs.getInt("idStatus"), rs.getString("Name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public int insert(Status status) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_STATUS);

        ps.setInt(1, status.getId());
        ps.setString(2, status.getName());

        int result = ps.executeUpdate();
        System.out.println("Status with id " + status.getId() + " was created in DB with following details: " + status);

        try {
            statuses.add(status);
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
    public int update(Status status) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS + status.getId());

        ps.setInt(1, status.getId());
        ps.setString(2, status.getName());

        int result = ps.executeUpdate();
        System.out.println("Status with id " + status.getId() + " was updated in DB with following details: " + status);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(Status status) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_STATUS + status.getId());
            System.out.println("Status with id " + status.getId() + " was removed from the DB");
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
