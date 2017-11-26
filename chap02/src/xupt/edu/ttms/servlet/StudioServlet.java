package xupt.edu.ttms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.edu.ttms.dao.StudioDAO;
import xupt.edu.ttms.model.Studio;

@WebServlet("/studio")
public class StudioServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        StudioDAO studioServlet = new StudioDAO();
        List<Studio> studios = studioServlet.findStudioAll();
        request.setAttribute("studios", studios);
        request.getRequestDispatcher("manager/studio.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

}
