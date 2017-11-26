package xupt.edu.ttms.dao;

import xupt.edu.ttms.idao.IEmployee;
import xupt.edu.ttms.idao.IStudio;

public class DAOFactory
{
    public static IEmployee creatEmployeeDAO()
    {
        return new EmployeeDAO();
    }

    public static IStudio creatStudioDAO()
    {
        return new StudioDAO();
    }
}
