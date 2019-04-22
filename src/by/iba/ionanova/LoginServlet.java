package by.iba.ionanova;

import by.iba.ionanova.list.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        request.setAttribute("name", request.getParameter("name"));
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                .forward(request, response);*/

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (validateUser(name, password)) {
            request.setAttribute("name", name);
            request.getRequestDispatcher("/GroupServlet")
                    .forward(request, response);

            /*request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                    .forward(request, response);*/
        } else {
            request.setAttribute("errorMessage", "Invalid Login and password!!");

          /* request.setAttribute("group",
                    ListService.retrieveList());*/
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);

        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        /*PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Good morning </title>");
        out.println("</head>");
        out.println("<body>");
        out.println(" First Servlet");
        out.println("</body>");
        out.println("</html>");*/

        /*request.setAttribute("name","N.V.Patsei");
        request.setAttribute("password","111");*/

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }


    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("admin") && password.equals("admin");
    }
}
