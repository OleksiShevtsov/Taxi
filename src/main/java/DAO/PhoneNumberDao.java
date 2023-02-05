package DAO;

import org.solvd.tableClasses.MyConnection;
import org.solvd.tableClasses.PhoneNumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneNumberDao extends MySqlDao implements IBaseDao<PhoneNumber> {
    private List<PhoneNumber> phoneNumbers;
    Connection connection;
    private final static String GET_PHONE_NUMBER_BY_ID = "SELECT * FROM PhoneNumbers WHERE idPhoneNumbers = ";
    private final static String GET_ALL_PHONE_NUMBERS = "SELECT * FROM PhoneNumbers";
    private final static String INSERT_PHONE_NUMBER = "INSERT INTO PhoneNumbers (idPhoneNumbers, Number, Users_idUsers) VALUES (?, ?, ?)";
    private final static String UPDATE_PHONE_NUMBER = "UPDATE PhoneNumbers SET idPhoneNumbers = ?, Number = ?, Users_idUsers = ? WHERE idPhoneNumbers = ";
    private final static String DELETE_PHONE_NUMBER = "DELETE FROM PhoneNumbers WHERE idPhoneNumbers = ";

    public PhoneNumberDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<PhoneNumber> getEntityById(int id) throws SQLException {
        PhoneNumber phoneNumber = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_PHONE_NUMBER_BY_ID + id);
        while (rs.next()) {
            phoneNumber = (new PhoneNumber(rs.getInt("idPhoneNumbers"), rs.getString("Number"),
                    rs.getInt("Users_idUsers")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(phoneNumber);
    }

    @Override
    public List<PhoneNumber> getAll() {
        phoneNumbers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_PHONE_NUMBERS);
            while (rs.next()) {
                phoneNumbers.add(new PhoneNumber(rs.getInt("idPhoneNumbers"), rs.getString("Number"),
                        rs.getInt("Users_idUsers")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneNumbers;
    }

    @Override
    public int insert(PhoneNumber phoneNumber) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_PHONE_NUMBER);

        ps.setInt(1, phoneNumber.getId());
        ps.setString(2, phoneNumber.getNumber());
        ps.setInt(3, phoneNumber.getUserId());

        int result = ps.executeUpdate();
        System.out.println("Phone number with id " + phoneNumber.getId() + " was created in DB with following details: "
                + phoneNumber);

        try {
            phoneNumbers.add(phoneNumber);
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
    public int update(PhoneNumber phoneNumber) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_PHONE_NUMBER + phoneNumber.getId());
        ps.setInt(1, phoneNumber.getId());
        ps.setString(2, phoneNumber.getNumber());
        ps.setInt(3, phoneNumber.getUserId());

        int result = ps.executeUpdate();
        System.out.println("Phone number with id " + phoneNumber.getId() + " was updated in DB with following details: " + phoneNumber);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(PhoneNumber phoneNumber) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_PHONE_NUMBER + phoneNumber.getId());
            System.out.println("Phone number with id " + phoneNumber.getId() + " was removed from the DB");
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


