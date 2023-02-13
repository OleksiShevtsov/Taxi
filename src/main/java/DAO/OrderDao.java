package main.java.DAO;

import main.java.org.solvd.tableClasses.MyConnection;
import main.java.org.solvd.tableClasses.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDao extends MySqlDao implements IBaseDao<Order> {
    private List<Order> orders;
    Connection connection;
    private final static String GET_ORDER_BY_ID = "SELECT * FROM Orders WHERE idOrders = ";
    private final static String GET_ALL_ORDERS = "SELECT * FROM Orders";
    private final static String INSERT_ORDER = "INSERT INTO Orders (idOrders, Price, DeparturePoint, DestinationPoint, " +
            "DefaultCity_idDefaultCity, Users_idUsers, Status_idStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_ORDER = "UPDATE Orders SET idOrders = ?, Price = ?, DeparturePoint = ?," +
            "DestinationPoint =?, DefaultCity_idDefaultCity = ?, Users_idUsers = ?, Status_idStatus = ? WHERE idOrders = ";
    private final static String DELETE_ORDER = "DELETE FROM Orders WHERE idOrders = ";

    public OrderDao() {
        MyConnection myConnection = new MyConnection();
        connection = myConnection.getConnection();
    }

    @Override
    public Optional<Order> getEntityById(int id) throws SQLException {
        Order order = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_ORDER_BY_ID + id);
        while (rs.next()) {
            order = (new Order(rs.getInt("idOrders"), rs.getDouble("Price"),
                    rs.getString("DeparturePoint"), rs.getString("DestinationPoint"),
                    rs.getInt("DefaultCity_idDefaultCity"), rs.getInt("Users_idUsers"),
                    rs.getInt("Status_idStatus")));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(order);
    }

    @Override
    public List<Order> getAll() {
        orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_ORDERS);
            while (rs.next()) {
                orders.add(new Order(rs.getInt("idOrders"), rs.getDouble("Price"),
                        rs.getString("DeparturePoint"), rs.getString("DestinationPoint"),
                        rs.getInt("DefaultCity_idDefaultCity"), rs.getInt("Users_idUsers"),
                        rs.getInt("Status_idStatus")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public int insert(Order order) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(INSERT_ORDER);

        ps.setInt(1, order.getId());
        ps.setDouble(2, order.getPrice());
        ps.setString(3, order.getDeparturePoint());
        ps.setString(4, order.getDestinationPoint());
        ps.setInt(5, order.getIdDefaultCity());
        ps.setInt(6, order.getIdUser());
        ps.setInt(7, order.getIdStatus());

        int result = ps.executeUpdate();
        System.out.println("City with id " + order.getId() + " was created in DB with following details: " + order);

        try {
            orders.add(order);
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
    public int update(Order order) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER + order.getId());

        ps.setInt(1, order.getId());
        ps.setDouble(2, order.getPrice());
        ps.setString(3, order.getDeparturePoint());
        ps.setString(4, order.getDestinationPoint());
        ps.setInt(5, order.getIdDefaultCity());
        ps.setInt(6, order.getIdUser());
        ps.setInt(7, order.getIdStatus());

        int result = ps.executeUpdate();
        System.out.println("Order with id " + order.getId() + " was updated in DB with following details: " + order);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(Order order) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_ORDER + order.getId());
            System.out.println("Order with id " + order.getId() + " was removed from the DB");
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
