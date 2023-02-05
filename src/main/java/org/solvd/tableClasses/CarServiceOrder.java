package org.solvd.tableClasses;

import java.util.Objects;

public class CarServiceOrder {
    private int id;
    private String serviceName;
    private String serviceDate;
    private double price;
    private int idCar;
    private int idCarService;

    public CarServiceOrder(int id, String serviceName, String serviceDate, double price, int idCar, int idCarService) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceDate = serviceDate;
        this.price = price;
        this.idCar = idCar;
        this.idCarService = idCarService;
    }

    public CarServiceOrder(int id) {
        this.id = id;
    }

    public CarServiceOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdCarService() {
        return idCarService;
    }

    public void setIdCarService(int idCarService) {
        this.idCarService = idCarService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarServiceOrder that = (CarServiceOrder) o;
        return id == that.id && Double.compare(that.price, price) == 0 && idCar == that.idCar && idCarService == that.idCarService && serviceName.equals(that.serviceName) && serviceDate.equals(that.serviceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, serviceDate, price, idCar, idCarService);
    }

    @Override
    public String toString() {
        return "CarServiceOrder{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDate='" + serviceDate + '\'' +
                ", price=" + price +
                ", idCar=" + idCar +
                ", idCarService=" + idCarService +
                '}';
    }
}
