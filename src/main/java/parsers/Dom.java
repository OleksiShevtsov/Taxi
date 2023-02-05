package parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Dom {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }
        Document doc = null;
        try {
            doc = documentBuilder.parse(new File("src/main/java/files/users.xml"));
        } catch (SAXException | IOException ex) {
            throw new RuntimeException(ex);
        }

        NodeList usersList = doc.getElementsByTagName("user"); // в переменную usersList списка Node записывается элемент по имени тэга "user"

        for (int i = 0; i < usersList.getLength(); i++) { // бежим по списку и записывем текущее значение в переменную
            Node u = usersList.item(i); //u интерфейса Node
            //  System.out.println("Node name: " + u.getNodeName() + " " + (i + 1)); // [user: null]
            if (u.getNodeType() == Node.ELEMENT_NODE) { // если текущее значение - элемент
                Element user = (Element) u; // записываем в переменную user интерфейса Element текущее значение
                String id = user.getAttribute("id");
                NodeList userChildNodes = user.getChildNodes(); // создаем список вложенных нодов переменной user
                for (int j = 0; j < userChildNodes.getLength(); j++) { // бежим по этому списку
                    Node n = userChildNodes.item(j); // записываем текущее значение в переменную n интерфейса Node
                    //       System.out.println(n);
                    if (n.getNodeType() == Node.ELEMENT_NODE) {
                        Element name = (Element) n;
                        String oid = name.getAttribute("id");
                        System.out.println("User with " + id + ": " + name.getTagName() + " " + oid + " = "
                                + name.getTextContent().replaceAll("\n", ""));
                    }
                }
            }
        }
    }
}
