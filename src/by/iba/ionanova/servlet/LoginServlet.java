package by.iba.ionanova.servlet;

import by.iba.ionanova.dao.UserDao;
import by.iba.ionanova.list.ListService;
import by.iba.ionanova.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        request.setAttribute("name", request.getParameter("name"));
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                .forward(request, response);*/

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();

       // if (validateUser(name, password)) {
        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {

            Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
            userCookie.setMaxAge(60 * 60 * 24 * 365); //хранить куки год
            response.addCookie(userCookie);

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (name.equals(cookie.getName())) {
                        request.setAttribute("lastdate", cookie.getValue());
                    }
                }
            }

            request.getSession().setAttribute("username",name);
           // request.setAttribute("name", name);
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


   /* public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("admin") && password.equals("admin");
    }*/
}
