package org.solvd;

//import java.util.Date;
import java.sql.Date;
import java.util.Objects;

public class License {
    private int id;
    private int number;
    private Date expirationDate;
    private Integer idUser;

    public License(int id, int number, Date expirationDate, int idUser) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.idUser = idUser;
    }

    public License(int id) {
        this.id = id;
    }

    public License() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof License)) return false;
        License license = (License) o;
        return getId() == license.getId() && getNumber() == license.getNumber() && getIdUser() == license.getIdUser() && getExpirationDate().equals(license.getExpirationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getExpirationDate(), getIdUser());
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", number=" + number +
                ", expirationDate=" + expirationDate +
                ", idUser=" + idUser +
                '}';
    }
}
