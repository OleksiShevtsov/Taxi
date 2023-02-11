package main.java.parsers;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement
@XmlType(propOrder = {"id", "model", "fuel", "mileage"})
public class TestCar {
    private int id;
    private String model;
    private String fuel;
    private int mileage;

    public TestCar(int id, String model, String fuel, int mileage) {
        this.id = id;
        this.model = model;
        this.fuel = fuel;
        this.mileage = mileage;
    }

    public TestCar() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    @XmlElement
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getMileage() {
        return mileage;
    }

    @XmlElement
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCar testCar = (TestCar) o;
        return id == testCar.id && mileage == testCar.mileage && model.equals(testCar.model) && fuel.equals(testCar.fuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, fuel, mileage);
    }

    @Override
    public String toString() {
        return "TestCar{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", fuel='" + fuel + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}
