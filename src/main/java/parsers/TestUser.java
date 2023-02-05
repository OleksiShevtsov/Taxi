package parsers;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Objects;

@JsonRootName(value = "testUser")
@XmlRootElement
@XmlType(propOrder = {"id", "firstName", "lastName", "age", "license", "cars"})
public class TestUser {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private TestLicense license;
    private List <TestCar> cars;

    public TestUser(int id, String firstName, String lastName, int age, TestLicense license, List<TestCar> cars) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.license = license;
        this.cars = cars;

    }

    public TestUser() {
    }

    public int getId() {
        return id;
    }

    @JsonAnySetter
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

    public TestLicense getLicense() {
        return license;
    }

    @XmlElement
    public void setLicense(TestLicense license) {
        this.license = license;
    }

    public List<TestCar> getCars() {
        return cars;
    }

    @XmlElement
    public void setCars(List<TestCar> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestUser testUser = (TestUser) o;
        return id == testUser.id && age == testUser.age && firstName.equals(testUser.firstName) &&
                lastName.equals(testUser.lastName) && license.equals(testUser.license) && cars.equals(testUser.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, license, cars);
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", license=" + license +
                ", cars=" + cars +
                '}';
    }
}
