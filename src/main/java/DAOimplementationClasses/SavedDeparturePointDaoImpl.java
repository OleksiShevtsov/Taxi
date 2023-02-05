package DAOimplementationClasses;

import DAO.SavedDeparturePointDao;
import org.solvd.tableClasses.SavedDeparturePoint;
import org.solvd.tableClasses.SavedDestinationPoint;

import java.sql.SQLException;

public class SavedDeparturePointDaoImpl {

    public static void main(String[] args) throws SQLException {
        SavedDeparturePoint departurePoint1 = new SavedDeparturePoint(1, "Park lane, 12", 1);
        SavedDeparturePoint departurePoint2 = new SavedDeparturePoint(2, "15-th str, 125", 2);
        SavedDeparturePoint departurePoint3 = new SavedDeparturePoint(3, "Shore bul, 10", 3);
        SavedDeparturePoint departurePoint4 = new SavedDeparturePoint(4, "Comfort town, 34", 4);
        SavedDeparturePoint departurePoint5 = new SavedDeparturePoint(5, "23-th str, 112", 5);
        SavedDeparturePointDao savedDeparturePointDao = new SavedDeparturePointDao();

        savedDeparturePointDao.insert(departurePoint5);
     //   savedDeparturePointDao.update(new SavedDeparturePoint(5, "23-th str, 113", 5));
     //   System.out.println(savedDeparturePointDao.getEntityById(2));
      //  System.out.println(savedDeparturePointDao.getAll());
      //  savedDeparturePointDao.delete(departurePoint5);
    }
}
