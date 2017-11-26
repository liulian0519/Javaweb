package xupt.edu.ttms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.edu.ttms.dao.EmployeeDAO;
import xupt.edu.ttms.model.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = -8587686065161504795L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        EmployeeDAO employServlet = new EmployeeDAO();
        List<Employee> employees = employServlet.findEmployeeAll();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("manager/user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

}
// public class EmployeeServlet extends HttpServlet
// {
// private static final long serialVersionUID = 1L;
//
// protected void doGet(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// doPost(request, response);
// }
//
// protected void doPost(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// String servletPath = request.getServletPath();
// String methodName = servletPath.substring(1);
// methodName = methodName.substring(0, methodName.length() - 3);
// Method method;
// try
// {
// method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
// HttpServletResponse.class);
// method.invoke(this, request, response);
// }
// catch(Exception e)
// {
// // TODO 自动生成的 catch 块
// // e.printStackTrace();
// response.sendRedirect("error.jsp");
// }
// }
//
// @SuppressWarnings("unused")
// private void login(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// String id = request.getParameter("id");
// EmployeeDAO employeeDao = new EmployeeDAO();
// employeeDao.delete(Integer.parseInt(id));
// request.getRequestDispatcher("/delete.jsp").forward(request, response);
// }
//
// @SuppressWarnings("unused")
// private void delete(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// String id = request.getParameter("id");
// EmployeeDAO employeeDao = new EmployeeDAO();
// employeeDao.delete(Integer.parseInt(id));
// request.getRequestDispatcher("/delete.jsp").forward(request, response);
// }
//
// @SuppressWarnings("unused")
// private void findEmployeeAll(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// EmployeeDAO employeedao = new EmployeeDAO();
// List<Employee> employees = employeedao.findEmployeeAll();
// request.setAttribute("employees", employees);
// request.getRequestDispatcher("/user.jsp").forward(request, response);
// }
//
// @SuppressWarnings("unused")
// private void insert(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// Employee employee = new Employee();
// EmployeeDAO employeedao = new EmployeeDAO();
// boolean employees = employeedao.insert(employee);
// request.setAttribute("employees", employees);
// request.getRequestDispatcher("/user.jsp").forward(request, response);
// }
//
// @SuppressWarnings("unused")
// private void update(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// Employee employee = new Employee();
// EmployeeDAO employeedao = new EmployeeDAO();
// boolean employees = employeedao.update(employee);
// request.setAttribute("employees", employees);
// request.getRequestDispatcher("/user.jsp").forward(request, response);
// }
//
// @SuppressWarnings("unused")
// private void findEmployeeByName(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// String employeeName = request.getParameter("employeeName");
// EmployeeDAO employServlet = new EmployeeDAO();
// List<Employee> employees = employServlet.findEmployeeByName(employeeName);
// request.setAttribute("employees", employees);
// request.getRequestDispatcher("/user.jsp").forward(request, response);
// }
//
// @SuppressWarnings("unused")
// private void findEmployeeById(HttpServletRequest request, HttpServletResponse response)
// throws ServletException, IOException
// {
// String id = request.getParameter("id");
// EmployeeDAO employServlet = new EmployeeDAO();
// Employee employees = employServlet.findEmployeeById(Integer.parseInt(id));
// request.setAttribute("employees", employees);
// request.getRequestDispatcher("/user.jsp").forward(request, response);
// }

// }
