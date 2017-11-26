package xupt.edu.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import xupt.edu.ttms.idao.IStudio;
import xupt.edu.ttms.model.ConnectionManager;
import xupt.edu.ttms.model.Employee;
import xupt.edu.ttms.model.Studio;

public class StudioDAO implements IStudio
{

    @Override
    public boolean insert(Employee employee)
    {
        // TODO 自动生成的方法存根
        return false;
    }

    @Override
    public boolean delete(int employeeId)
    {
        // TODO 自动生成的方法存根
        return false;
    }

    @Override
    public boolean update(Employee employee)
    {
        // TODO 自动生成的方法存根
        return false;
    }

    @SuppressWarnings("finally")
    @Override
    public ArrayList<Studio> findStudioAll()
    {
        ArrayList<Studio> list = new ArrayList<Studio>();
        Studio info = null;
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from studio");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                info = new Studio();
                info.setStudio_id(rs.getInt("Studio_id"));
                info.setStudio_name(rs.getString("Studio_name"));
                info.setStudio_row_count(rs.getInt("Studio_row_count"));
                info.setStudio_col_count(rs.getInt("Studio_col_count"));
                info.setStudio_introduction(rs.getString("Studio_introduction"));
                info.setStudio_flag(rs.getInt("Studio_flag"));
                // 加入列表
                list.add(info);
            }
            System.out.println("##########");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return list;
        }
    }

    @Override
    public ArrayList<Employee> findEmployeeByName(String employeeName)
    {
        // TODO 自动生成的方法存根
        return null;
    }

    @Override
    public Employee findEmployeeById(int employeeId)
    {
        // TODO 自动生成的方法存根
        return null;
    }

}
