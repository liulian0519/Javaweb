package xupt.edu.ttms.idao;

import java.util.ArrayList;

import xupt.edu.ttms.model.Employee;
import xupt.edu.ttms.model.User;

public interface IUser
{
    // 增
    public boolean insert(Employee employee);

    // 删
    public boolean delete(int employeeId);

    // 改
    public boolean update(Employee employee);

    // 查所有用户(一般用于和界面交互)
    public ArrayList<Employee> findEmployeeAll();

    // 根据用户名查(一般用于和界面交互)
    public ArrayList<Employee> findEmployeeByName(String employeeName);

    // 根据用户id查(一般用于数据内部关联操作)
    public Employee findEmployeeById(int employeeId);

    public User getInfo(String userno, String userpass);
}
