package org.solvd;

import java.util.Objects;

public class Order {
    private int id;
    private double price;
    private String DeparturePoint;
    private String DestinationPoint;
    private int idDefaultCity;
    private int idUser;
    private int idStatus;

    public Order(int id, double price, String departurePoint, String destinationPoint, int idDefaultCity, int idUser, int idStatus) {
        this.id = id;
        this.price = price;
        DeparturePoint = departurePoint;
        DestinationPoint = destinationPoint;
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
        return DeparturePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        DeparturePoint = departurePoint;
    }

    public String getDestinationPoint() {
        return DestinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        DestinationPoint = destinationPoint;
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
                idUser == order.idUser && idStatus == order.idStatus && DeparturePoint.equals(order.DeparturePoint) &&
                DestinationPoint.equals(order.DestinationPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, DeparturePoint, DestinationPoint, idDefaultCity, idUser, idStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", DeparturePoint='" + DeparturePoint + '\'' +
                ", DestinationPoint='" + DestinationPoint + '\'' +
                ", idDefaultCity=" + idDefaultCity +
                ", idUser=" + idUser +
                ", idStatus='" + idStatus + '\'' +
                '}';
    }
}
