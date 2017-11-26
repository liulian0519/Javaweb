package xupt.edu.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xupt.edu.ttms.model.ConnectionManager;

public class UserDAO
{
    public String checkUser(String username, String password)
    {
        ResultSet rs = null;
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from user");
            rs = pstmt.executeQuery();
        }
        catch(Exception e)
        {
            System.err.println("查询数据库出错");
            e.printStackTrace();
            return null;
        }
        try
        {
            while(rs.next())
            {
                String temp_username = rs.getString("emp_no").trim();
                String temp_password = rs.getString("emp_pass").trim();
                if(username.equals(temp_username))
                {
                    if(password.equals(temp_password))
                    {
                        return "hasUserNameAndPasswordCorrect";
                    }
                    return "hasUserNameButPasswordInCorrect";
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("操作ResultSet出错");
            e.printStackTrace();
        }
        return "hasNoUserName";
    }

    public Integer checkType(String username, String password)
    {
        ResultSet rs = null;
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from user");
            rs = pstmt.executeQuery();
        }
        catch(Exception e)
        {
            System.err.println("查询数据库出错");
            e.printStackTrace();
            return null;
        }
        try
        {
            while(rs.next())
            {
                String temp_username = rs.getString("emp_no").trim();
                String temp_password = rs.getString("emp_pass").trim();
                Integer temp_type = rs.getInt("type");
                if(username.equals(temp_username))
                {
                    if(password.equals(temp_password))
                    {
                        return temp_type;
                    }
                    return 0;
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("操作ResultSet出错");
            e.printStackTrace();
        }
        return 0;
    }
}
