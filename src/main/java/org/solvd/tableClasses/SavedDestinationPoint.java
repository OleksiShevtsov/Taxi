package org.solvd.tableClasses;

import java.util.Objects;

public class SavedDestinationPoint {
    private int id;
    private String address;
    private int idOrder;

    public SavedDestinationPoint(int id, String address, int idOrder) {
        this.id = id;
        this.address = address;
        this.idOrder = idOrder;
    }

    public SavedDestinationPoint(int id) {
        this.id = id;
    }

    public SavedDestinationPoint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedDestinationPoint that = (SavedDestinationPoint) o;
        return id == that.id && idOrder == that.idOrder && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, idOrder);
    }

    @Override
    public String toString() {
        return "SavedDestinationPoint{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", idOrder=" + idOrder +
                '}';
    }
}
