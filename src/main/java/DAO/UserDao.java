package DAO;

import org.solvd.tableClasses.MyConnection;
import org.solvd.tableClasses.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao extends MySqlDao implements IBaseDao<User> {
    private List<User> users;
    Connection connection;
    private final static String GET_USER_BY_ID = "SELECT * FROM Users WHERE idUsers = ";
    private final static String GET_ALL_USERS = "SELECT * FROM Users";
    private final static String INSERT_USER = "INSERT INTO Users (idUsers, FirstName, LastName, Age, Role_idRole) VALUES (?, ?, ?, ?, ?)";
    private final static String UPDATE_USER = "UPDATE Users SET idUsers = ?, FirstName = ?, LastName = ?, Age = ?, Role_idRole =? WHERE idUsers = ";
    private final static String DELETE_USER = "DELETE FROM Users WHERE idUsers = ";

    public UserDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<User> getEntityById(int id) throws SQLException {
        User user = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_USER_BY_ID + id);
        while (rs.next()) {
            user = (new User(rs.getInt("idUsers"), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt("Age"), rs.getInt("Role_idRole")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_USERS);
            while (rs.next()) {
                users.add(new User(rs.getInt("idUsers"), rs.getString("FirstName"),
                        rs.getString("LastName"), rs.getInt("Age"), rs.getInt("Role_idRole")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int insert(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_USER);

        ps.setInt(1, user.getId());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setInt(4, user.getAge());
        ps.setInt(5, user.getRoleId());

        int result = ps.executeUpdate();
        System.out.println("UserTest with id " + user.getId() + " was created in DB with following details: " + user.toString());

        try {
            users.add(user);
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
    public int update(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_USER + user.getId());
        ps.setInt(1, user.getId());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setInt(4, user.getAge());
        ps.setInt(5, user.getRoleId());

        int result = ps.executeUpdate();
        System.out.println("UserTest with id " + user.getId() + " was updated in DB with following details: " + user);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(User user) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_USER + user.getId());
            System.out.println("UserTest with id " + user.getId() + " was removed from the DB");
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
