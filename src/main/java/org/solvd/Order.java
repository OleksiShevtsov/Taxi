package org.solvd;

import java.util.Objects;

public class Order {
    private int id;
    private double price;
    private String departurePoint;
    private String destinationPoint;
    private int idDefaultCity;
    private int idUser;
    private int idStatus;

    public Order(int id, double price, String departurePoint, String destinationPoint, int idDefaultCity, int idUser, int idStatus) {
        this.id = id;
        this.price = price;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.idDefaultCity = idDefaultCity;
        this.idUser = idUser;
        this.idStatus = idStatus;
    }

    public Order(int id) {
        this.id = id;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public int getIdDefaultCity() {
        return idDefaultCity;
    }

    public void setIdDefaultCity(int idDefaultCity) {
        this.idDefaultCity = idDefaultCity;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.price, price) == 0 && idDefaultCity == order.idDefaultCity &&
                idUser == order.idUser && idStatus == order.idStatus && departurePoint.equals(order.departurePoint) &&
                destinationPoint.equals(order.destinationPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departurePoint, destinationPoint, idDefaultCity, idUser, idStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", DeparturePoint='" + departurePoint + '\'' +
                ", DestinationPoint='" + destinationPoint + '\'' +
                ", idDefaultCity=" + idDefaultCity +
                ", idUser=" + idUser +
                ", idStatus='" + idStatus + '\'' +
                '}';
    }
}
