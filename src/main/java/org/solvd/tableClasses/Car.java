package main.java.org.solvd.tableClasses;

import java.util.Objects;

public class Car {
    private int id;
    private String model;
    private int userId;
    private String registrationNumber;
    private int mileage;
    private String fuel;

    public Car(int id, String model, int users_idUsers, String registrationNumber, int mileage, String fuel) {
        this.id = id;
        this.model = model;
        this.userId = users_idUsers;
        this.registrationNumber = registrationNumber;
        this.mileage = mileage;
        this.fuel = fuel;
    }

    public Car(int id) {
        this.id = id;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && userId == car.userId && mileage == car.mileage && model.equals(car.model) && registrationNumber.equals(car.registrationNumber) && fuel.equals(car.fuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, userId, registrationNumber, mileage, fuel);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", users_idUsers=" + userId +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", mileage=" + mileage +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
