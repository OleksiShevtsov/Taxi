package DAOimplementationClasses;

import DAO.SavedDeparturePointDao;
import DAO.SavedDestinationPointDao;
import org.solvd.tableClasses.SavedDestinationPoint;

import java.sql.SQLException;

public class SavedDestinationPointDaoImpl {

    public static void main(String[] args) throws SQLException {
        SavedDestinationPoint destinationPoint1 = new SavedDestinationPoint(1, "Central station", 1);
        SavedDestinationPoint destinationPoint2 = new SavedDestinationPoint(2, "River park", 2);
        SavedDestinationPoint destinationPoint3 = new SavedDestinationPoint(3, "Atlantic port", 3);
        SavedDestinationPoint destinationPoint4 = new SavedDestinationPoint(4, "Railway station", 4);
        SavedDestinationPoint destinationPoint5 = new SavedDestinationPoint(5, "Central bul, 25", 5);
        SavedDestinationPointDao savedDestinationPointDao = new SavedDestinationPointDao();

        //   savedDestinationPointDao.insert(destinationPoint5);
        //  savedDestinationPointDao.update(new SavedDestinationPoint(5, "Central bul, 26", 5));
        //  System.out.println(savedDestinationPointDao.getEntityById(4));
        //  System.out.println(savedDestinationPointDao.getAll());
        //    savedDestinationPointDao.delete(destinationPoint1);
    }
}
