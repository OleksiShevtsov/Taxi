package org.solvd;

import DAO.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

//       // JAXB:
        Role role = new Role(2, "Admin");
        User user = new User(1, "John", "Bolton", 33, role);
        File file = new File("src/main/java/files/myFile.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(user, file);
            marshaller.marshal(user, System.out);

            Unmarshaller unmarshaller = context.createUnmarshaller();;
           User user2 = (User) unmarshaller.unmarshal(file);
            System.out.println(user2.getId());
            System.out.println(user2.getFirstName());
            System.out.println(user2.getLastName());
            System.out.println(user2.getAge());
            System.out.println(user2.getRole());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // DOM:

//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//            Document doc = documentBuilder.parse(new File("src/main/java/files/users.xml"));
//
//            NodeList usersList = doc.getElementsByTagName("user"); // в переменную usersList списка Node записывается элемент по имени тэга "user"
//
//            for (int i = 0; i < usersList.getLength(); i++) { // бежим по списку и записывем текущее значение в переменную
//                Node u = usersList.item(i); //u интерфейса Node
//                //  System.out.println("Node name: " + u.getNodeName() + " " + (i + 1)); // [user: null]
//                if (u.getNodeType() == Node.ELEMENT_NODE) { // если текущее значение - элемент
//                    Element user = (Element) u; // записываем в переменную user интерфейса Element текущее значение
//                    String id = user.getAttribute("id");
//                    NodeList userChildNodes = user.getChildNodes(); // создаем список вложенных нодов переменной user
//                    for (int j = 0; j < userChildNodes.getLength(); j++) { // бежим по этому списку
//                        Node n = userChildNodes.item(j); // записываем текущее значение в переменную n интерфейса Node
//                        //       System.out.println(n);
//                        if (n.getNodeType() == Node.ELEMENT_NODE) {
//                            Element name = (Element) n;
//                            String oid = name.getAttribute("id");
//                            System.out.println("User with " + id + ": " + name.getTagName() + " " + oid + " = "
//                                    + name.getTextContent().replaceAll("\n",""));
//                        }
//                    }
//                }
//            }
//
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }


//       myConnection.getConnection();
       //  UserDao userDao = new UserDao();
        // System.out.println(userDao.getEntityById(1));
//        List<UserTest> list = userDao.getAll();
//        for (UserTest e : list) {
//            System.out.println(e);
//        }
        // userDao.insert(new UserTest(8, "Ben", "Mladich", 43, 1));
        // userDao.update(new UserTest(8, "Ben", "Bladich", 48, 1));
        // userDao.delete(new UserTest(8));

//        PhoneNumberDao phoneNumberDao = new PhoneNumberDao();
//        phoneNumberDao.insert(new PhoneNumber(2, "0971230567", 7));

    }
}

