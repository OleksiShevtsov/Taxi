package parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.solvd.tableClasses.Role;
import org.solvd.tableClasses.User;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Jackson {

    public static void main(String[] args) {

        Role role = new Role(2, "Admin");
        User user = new User(1, "John", "Bolton", 33, 2);

        List<TestCar> cars = new ArrayList<>();
        cars.add(new TestCar(1, "Volvo", "diesel", 150000));
        cars.add(new TestCar(2, "BMW", "gasoline", 119000));
        cars.add(new TestCar(3, "Fiat", "gas", 13000));

        TestLicense testLicense = new TestLicense(1, 3456, new Date(123, 12, 23));
        TestUser testUser = new TestUser(1, "Jack", "Williams", 23, testLicense, cars);

        File userJSON = new File("src/main/java/files/user.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(userJSON, testUser);
            TestUser testUser1 = objectMapper.readValue(userJSON, TestUser.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
