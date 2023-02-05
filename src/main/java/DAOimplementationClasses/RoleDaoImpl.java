package DAOimplementationClasses;

import DAO.RoleDao;
import org.solvd.tableClasses.Role;

import java.sql.SQLException;

public class RoleDaoImpl {

    public static void main(String[] args) throws SQLException {
        Role role1 = new Role(1, "Driver");
        RoleDao roleDao = new RoleDao();

           roleDao.insert(role1);
        //    roleDao.update(new Role(1, "Admin"));
        // System.out.println(roleDao.getEntityById(1));
        // System.out.println(roleDao.getAll());
        //  roleDao.delete(role1);
    }
}
