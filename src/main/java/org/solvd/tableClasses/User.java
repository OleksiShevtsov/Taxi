package org.solvd.tableClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@JsonRootName(value = "User")
@XmlRootElement
@XmlType(propOrder = {"id", "firstName", "lastName", "age", "roleId"})
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int roleId;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age, int roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.roleId = roleId;
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getRoleId() {
        return roleId;
    }

    @XmlElement
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && age == user.age && roleId == user.roleId && firstName.equals(user.firstName) &&
                lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, roleId);
    }

    @Override
    public String toString() {
        return "User: " +
                "id:" + id +
                ", first name:'" + firstName + '\'' +
                ", last name:'" + lastName + '\'' +
                ", age:" + age +
                ", role:" + roleId;
    }
}
