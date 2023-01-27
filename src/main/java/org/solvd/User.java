package org.solvd;

import java.util.Objects;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoleId() {
        return roleId;
    }

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
        return "UserTest : " +
                "id:" + id +
                ", first name:'" + firstName + '\'' +
                ", last name:'" + lastName + '\'' +
                ", age:" + age +
                ", roleId:" + roleId;
    }
}
