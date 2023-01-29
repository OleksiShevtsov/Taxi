package org.solvd;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlType(propOrder = {"id", "firstName", "lastName", "age", "role"})
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Role role;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = role;
    }

    public User(int id) {
        this.id = id;
    }

    public User(int idUsers, String firstName, String lastName, int age, int role_idRole) {
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

    public Role getRole() {
        return role;
    }

    @XmlElement
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && age == user.age && role == user.role && firstName.equals(user.firstName) &&
                lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, role);
    }

    @Override
    public String toString() {
        return "UserTest : " +
                "id:" + id +
                ", first name:'" + firstName + '\'' +
                ", last name:'" + lastName + '\'' +
                ", age:" + age +
                ", role:" + role;
    }

    public int getRoleId() {
        return role.getId();
    }
}
