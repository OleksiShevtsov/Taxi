package DAOimplementationClasses;

import DAO.StatusDao;
import org.solvd.tableClasses.Status;

import java.sql.SQLException;

public class StatusDaoImpl {

    public static void main(String[] args) throws SQLException {
        Status status1 = new Status(1, "New");
        Status status2 = new Status(2, "Pending");
        Status status3 = new Status(3, "In progress");
        Status status4 = new Status(4, "Completed");
        Status status5 = new Status(5, "Cancelled");
        StatusDao statusDao = new StatusDao();

        statusDao.insert(status5);
        // statusDao.update(new Status(6, "Archived"));
        // System.out.println(statusDao.getEntityById(5));
        // System.out.println(statusDao.getAll());
        //    statusDao.delete(status5);
    }
}
