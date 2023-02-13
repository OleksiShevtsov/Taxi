package main.java.DAO;

import main.java.org.solvd.tableClasses.MyConnection;
import main.java.org.solvd.tableClasses.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDao extends MySqlDao implements IBaseDao<Role> {
    private List<Role> roles;
    Connection connection;
    private final static String GET_ROLE_BY_ID = "SELECT * FROM Role WHERE idRole = ";
    private final static String GET_ALL_ROLES = "SELECT * FROM Role";
    private final static String INSERT_ROLE = "INSERT INTO Role (idRole, Name) VALUES (?, ?)";
    private final static String UPDATE_ROLE = "UPDATE Role SET idRole = ?, Name = ? WHERE idRole = ";
    private final static String DELETE_ROLE = "DELETE FROM Role WHERE idRole = ";

    public RoleDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<Role> getEntityById(int id) throws SQLException {
        Role role = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_ROLE_BY_ID + id);
        while (rs.next()) {
            role = (new Role(rs.getInt("idRole"), rs.getString("Name")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(role);
    }

    @Override
    public List<Role> getAll() {
        roles = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_ROLES);
            while (rs.next()) {
                roles.add(new Role(rs.getInt("idRole"), rs.getString("Name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public int insert(Role role) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_ROLE);
        ps.setInt(1, role.getId());
        ps.setString(2, role.getName());

        int result = ps.executeUpdate();
        System.out.println("Role with id " + role.getId() + " was created in DB with following details: " + role);

        try {
            roles.add(role);
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
    public int update(Role role) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_ROLE + role.getId());
        ps.setInt(1, role.getId());
        ps.setString(2, role.getName());

        int result = ps.executeUpdate();
        System.out.println("Role with id " + role.getId() + " was updated in DB with following details: " + role);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(Role role) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_ROLE + role.getId());
            System.out.println("Role with id " + role.getId() + " was removed from the DB");
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
