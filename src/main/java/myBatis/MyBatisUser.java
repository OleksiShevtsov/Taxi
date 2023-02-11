package main.java.myBatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import main.java.org.solvd.tableClasses.User;
import main.java.DAO.UserDao;

public class MyBatisUser {
    static Reader reader;
    static SqlSessionFactory sqlSessionFactory;
    static SqlSession session;

    public static void main(String[] args) throws SQLException {
        User user = new User("Bill", "Omaha", 25, 2);

        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyBatisUser myBatisUser = new MyBatisUser();
         myBatisUser.insert(user);
        //  myBatisUser.update();
        // myBatisUser.selectById();
        // myBatisUser.selectAll();
        //  myBatisUser.delete();

    }

    public void insert(User user) {
        session.insert("User.insert", user);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();
    }

    public void update() {
        //select a particular user using id
        User user = session.selectOne("User.getById", 1);
        System.out.println("Current details of the user are");
        System.out.println(user);

        //Set new values to the user
        user.setFirstName(user.getFirstName());
        user.setLastName("Montana");
        user.setAge(30);
        user.setRoleId(user.getRoleId());

        //Update the user record
        session.update("User.update", user);
        System.out.println(user);
        session.commit();
        session.close();
    }

    public void selectById() {
        //select a particular user  by  id
        User user = session.selectOne("User.getById", 2);

        //Print the student details
        System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName() + " " +
                user.getAge() + " " + user.getRoleId() + "\n");
        session.commit();
        session.close();
    }

    public void selectAll() {
        List<User> users = session.selectList("User.getAll");

        for (User user : users) {
            System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName() + " " +
                    user.getAge() + " " + user.getRoleId() + "\n");
        }

        session.commit();
        session.close();
    }

    public void selectJoin() {
    }

    public void delete() {
        session.delete("User.deleteById", 18);
        session.commit();
        session.close();
        System.out.println("Record deleted successfully");
    }
}
