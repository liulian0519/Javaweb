package xupt.se.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import xupt.se.ttms.idao.IUser;
import xupt.se.ttms.model.User;
import xupt.se.util.ConnectionManager;

public class UserDAO implements IUser
{
    public static final int PAGE_SIZE = 3; // 每页显示条数
    private int allCount; // 数据库中条数
    private int allPageCount; // 总页数
    private int currentPage; // 当前页

    public int getAllCount()
    {
        return allCount;
    }

    public int getAllPageCount()
    {
        return allPageCount;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    @SuppressWarnings("finally")
    public ArrayList<User> findUserByPage(int cPage, String emp_no)
    {
        currentPage = cPage;
        ArrayList<User> list = new ArrayList<User>();
        if(null == emp_no || emp_no.equals(null))
        {
            emp_no = "";
        }
        // 若未指定编号 则默认全查
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取总记录数
            String sql1 = "select count(type) as AllRecord from user where emp_no like ?";
            conn = ConnectionManager.getInstance().getConnection();
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, "%" + emp_no + "%");
            rs = pstmt.executeQuery();
            if(rs.next())
                allCount = rs.getInt("AllRecord");
            rs.close();
            pstmt.close();
            // 记算总页数
            allPageCount = (allCount + PAGE_SIZE - 1) / PAGE_SIZE;

            // 如果当前页数大于总页数，则赋值为总页数
            if(allPageCount > 0 && currentPage > allPageCount)
                currentPage = allPageCount;
            // 获取currentpage页数据
            String sql2 = "select * from user where emp_no like ? limit ?,?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, "%" + emp_no + "%");
            pstmt.setInt(2, PAGE_SIZE * (currentPage - 1));
            pstmt.setInt(3, PAGE_SIZE);
            rs = pstmt.executeQuery();
            User user = null;
            while(rs.next())
            {
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_no(rs.getString("emp_no"));
                user.setUser_pass(rs.getString("emp_pass"));
                user.setUser_type(rs.getString("type"));
                list.add(user);

            }

        }
        catch(SQLException e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, conn);
            return list;
        }
    }

    @SuppressWarnings("finally")
    public boolean insert(User user)
    {
        boolean result = false;
        if(user == null)
            return result;

        // 获取Connection
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "insert into user(emp_no, emp_pass, emp_type) values(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUser_no());
            pstmt.setString(2, user.getUser_pass());
            pstmt.setString(3, user.getUser_type());
            pstmt.executeUpdate();
            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    @SuppressWarnings("finally")
    public ArrayList<User> findUserAll()
    {
        ArrayList<User> list = new ArrayList<User>();
        User info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from user");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                info = new User();
                info.setUser_id(rs.getInt("user_id"));
                info.setUser_no(rs.getString("emp_no"));
                info.setUser_pass(rs.getString("emp_pass"));
                info.setUser_type(rs.getString("type"));

                // 加入列表
                list.add(info);
            }
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

    @SuppressWarnings("finally")
    public boolean isExist(String emp_no, String emp_pass)
    {
        boolean result = false;
        Connection con = ConnectionManager.getInstance().getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String password = null;

        try
        {
            String sql = "select emp_pass from user where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, emp_no);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                password = rs.getString("emp_pass");
            }
            if(password != null && password.equals(emp_pass))
                result = true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return result;
        }
    }

    // public static void main(String[] args)
    // {
    // UserDAO dao = new UserDAO();
    // System.out.println(dao.judgeUser("001", "123456"));
    // }
}
