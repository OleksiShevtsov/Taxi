package main.java.myBatis;

import main.java.org.solvd.tableClasses.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import main.java.org.solvd.tableClasses.Role;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisRole {

    static Reader reader;
    static SqlSessionFactory sqlSessionFactory;
    static SqlSession session;

    public static void main(String[] args) {
        Role role = new Role("Manager");

        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyBatisRole myBatisRole = new MyBatisRole();
       // myBatisRole.insert(role);
       // myBatisRole.update();
       // myBatisRole.selectById();
       // myBatisRole.selectAll();
        myBatisRole.delete();
    }

    public void insert(Role role) {
        session.insert("Role.insert", role);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();
    }

    public void update() {
        Role role = session.selectOne("Role.getById", 2);
        System.out.println("Current details of the role are");
        System.out.println(role);

        role.setName("Administrator");

        session.update("Role.update", role);
        System.out.println(role);
        session.commit();
        session.close();
    }

    public void selectById() {
        Role role = session.selectOne("Role.getById", 2);

        System.out.println(role.getId() + " " + role.getName() + "\n");
        session.commit();
        session.close();
    }

    public void selectAll() {
        List<Role> roles = session.selectList("Role.getAll");

        for (Role role : roles) {
            System.out.println(role.getId() + " " + role.getName() + "\n");
        }

        session.commit();
        session.close();
    }

    public void delete() {
        session.delete("Role.deleteById", 6);
        session.commit();
        session.close();
        System.out.println("Record deleted successfully");
    }
}
