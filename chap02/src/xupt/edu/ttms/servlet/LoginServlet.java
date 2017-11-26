package xupt.edu.ttms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.edu.ttms.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String String = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().setAttribute("login", "ok");
        request.getSession().setAttribute("manager", null);
        request.getSession().setAttribute("customer", null);
        request.getSession().invalidate();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        // String type = request.getParameter("type");
        // int itype = Integer.parseInt(type);
        String page = "user.jsp";
        UserDAO mss = new UserDAO();
        String result1 = "用户名正确,密码不正确!";
        String result2 = "没有此用户";
        String result4 = "对不起，您无权限";
        String result = mss.checkUser(name, pass);
        Integer result3 = mss.checkType(name, pass);
        if(result.equals("hasUserNameAndPasswordCorrect"))
        {
            System.out.println("用户名和密码均正确");

            if(result3 == 1)
            {
                request.getSession().setAttribute("login", "ok");
                request.getSession().setAttribute("manager", "ok");
                page = "employee";
            }
            else
                if(result3 == 2)
                {
                    request.getSession().setAttribute("login", "ok");
                    request.getSession().setAttribute("customer", "ok");
                    page = "cstudio";
                }

        }
        else
            if(result.equals("hasUserNameButPasswordInCorrect"))
            {
                System.out.println("用户名正确,密码不正确");
                request.setAttribute("desc", result1);

            }
            else
                if(result.equals("hasNoUserName"))
                {
                    System.out.println("没有此用户");
                    request.setAttribute("desc", result2);

                }
        request.getRequestDispatcher(page).forward(request, response);
    }
}
