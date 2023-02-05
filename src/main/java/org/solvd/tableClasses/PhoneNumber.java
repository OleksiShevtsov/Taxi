package org.solvd.tableClasses;

import java.util.Objects;

public class PhoneNumber {
    private int id;
    private String number;
    private int userId;

    public PhoneNumber(int id, String number, int userId) {
        this.id = id;
        this.number = number;
        this.userId = userId;
    }

    public PhoneNumber(int id) {
        this.id = id;
    }

    public PhoneNumber() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return id == that.id && userId == that.userId && number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, userId);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userId=" + userId +
                '}';
    }
}
