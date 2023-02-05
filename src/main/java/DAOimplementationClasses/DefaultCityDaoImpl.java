package DAOimplementationClasses;

import DAO.DefaultCityDao;
import org.solvd.tableClasses.DefaultCity;

import java.sql.SQLException;

public class DefaultCityDaoImpl {

    public static void main(String[] args) throws SQLException {
        DefaultCity defaultCity1 = new DefaultCity(1, "New York");
        DefaultCity defaultCity2 = new DefaultCity(2, "Chicago");
        DefaultCity defaultCity3 = new DefaultCity(3, "Brighton");
        DefaultCity defaultCity4 = new DefaultCity(4, "Washington DC");
        DefaultCity defaultCity5 = new DefaultCity(5, "Philadelphia");
        DefaultCityDao defaultCityDao = new DefaultCityDao();

        defaultCityDao.insert(defaultCity5);
      //  defaultCityDao.update(defaultCity3 = new DefaultCity(3, "Boston"));
       // System.out.println(defaultCityDao.getEntityById(4));
     //   System.out.println(defaultCityDao.getAll());
       // defaultCityDao.delete(defaultCity5);
    }
}
