package org.solvd.tableClasses;

import java.util.Objects;

public class DefaultCity {
    private  int id;
    private String name;

    public DefaultCity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DefaultCity(int id) {
        this.id = id;
    }

    public DefaultCity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultCity that = (DefaultCity) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "DefaultCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
