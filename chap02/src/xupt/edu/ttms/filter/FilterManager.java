package xupt.edu.ttms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/manager/*")
public class FilterManager implements Filter
{
    public FilterManager()
    {
        // TODO Auto-generated constructor stub
    }

    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        System.out.println("进入过滤器FilterManager");
        HttpServletRequest req = (HttpServletRequest) request;
        String flag = (String) req.getSession().getAttribute("manager");
        if(flag == null || !flag.equals("ok"))
        {
            System.out.println("无权访问经理权限");
            request.setAttribute("desc", "无权访问经理权限");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        else
            chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException
    {
        // TODO Auto-generated method stub
    }

}
