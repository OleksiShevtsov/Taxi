package DAO;

import org.solvd.tableClasses.License;
import org.solvd.tableClasses.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LicenseDao extends MySqlDao implements IBaseDao<License> {
    private List<License> licenses;
    Connection connection;
    private final static String GET_LICENSE_BY_ID = "SELECT * FROM Licenses WHERE idLicenses = ";
    private final static String GET_ALL_LICENSES = "SELECT * FROM Licenses";
    private final static String INSERT_LICENSE = "INSERT INTO Licenses " + "(idLicenses, Number, ExpirationDate, Users_idUsers) " +
            "VALUES (?, ?, ?, ?)";
    private final static String UPDATE_LICENSE = "UPDATE Licenses SET idLicenses = ?, Number = ?, " + "ExpirationDate = ?, " +
            "Users_idUsers = ? WHERE idLicenses = ";
    private final static String DELETE_LICENSE = "DELETE FROM Licenses WHERE idLicenses = ";

    public LicenseDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<License> getEntityById(int id) throws SQLException {
        License license = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_LICENSE_BY_ID + id);
        while (rs.next()) {
            license = (new License(rs.getInt("idLicenses"), rs.getInt("Number"),
                    rs.getDate("ExpirationDate"), rs.getInt("Users_idUsers")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(license);
    }

    @Override
    public List<License> getAll() {
        licenses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_LICENSES);
            while (rs.next()) {
                licenses.add(new License(rs.getInt("idLicenses"), rs.getInt("Number"),
                        rs.getDate("ExpirationDate"), rs.getInt("Users_idUsers")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return licenses;
    }

    @Override
    public int insert(License license) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_LICENSE);

        ps.setInt(1, license.getId());
        ps.setInt(2, license.getNumber());
        ps.setDate(3, license.getExpirationDate());
        ps.setInt(4, license.getIdUser());

        int result = ps.executeUpdate();
        System.out.println("License with id " + license.getId() + " was created in DB with following details: " + license);

        try {
            licenses.add(license);
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
    public int update(License license) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_LICENSE + license.getId());

        ps.setInt(1, license.getId());
        ps.setInt(2, license.getNumber());
        ps.setDate(3, license.getExpirationDate());
        ps.setInt(4, license.getIdUser());

        int result = ps.executeUpdate();
        System.out.println("License with id " + license.getId() + " was updated in DB with following details: " + license);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(License license) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_LICENSE + license.getId());
            System.out.println("License with id " + license.getId() + " was removed from the DB");
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
