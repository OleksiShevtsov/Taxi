package parsers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Jaxb {

    public static void main(String[] args) {
        List<TestCar> cars = new ArrayList<>();
        cars.add(new TestCar(1, "Volvo", "diesel", 150000));
        cars.add(new TestCar(2, "BMW", "gasoline", 119000));
        cars.add(new TestCar(3, "Fiat", "gas", 13000));

        TestLicense testLicense = new TestLicense(1, 3456, new Date(123, 12, 23));
        TestUser testUser = new TestUser(1, "Jack", "Williams", 23, testLicense, cars);

        File fileUser = new File("src/main/java/files/myFile.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(TestUser.class, TestCar.class, TestLicense.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(testUser, fileUser);
            marshaller.marshal(testUser, System.out);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            TestUser testUser1 = (TestUser) unmarshaller.unmarshal(fileUser);

            System.out.println(testUser1.getId());
            System.out.println(testUser1.getFirstName());
            System.out.println(testUser1.getLastName());
            System.out.println(testUser1.getAge());
            System.out.println(testUser1.getLicense());
            System.out.println(testUser1.getCars());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
