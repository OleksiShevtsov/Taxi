package main.java.parsers;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.Objects;

@XmlRootElement
@XmlType(propOrder = {"id", "number", "expirationDate"})
public class TestLicense {
    private int id;
    private int number;
    private Date expirationDate;

    public TestLicense(int id, int number, Date expirationDate) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public TestLicense() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    @XmlElement
    public void setNumber(int number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestLicense that = (TestLicense) o;
        return id == that.id && number == that.number && expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, expirationDate);
    }

    @Override
    public String toString() {
        return "TestLicense{" +
                "id=" + id +
                ", number=" + number +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
