package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Claudiu.Brandabur on 19-Jul-17.
 */
public class HttpSessionLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Cookie[] cookies = request.getCookies();

        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            PrintWriter pw = response.getWriter();
            pw.write("<h1>Welcome back " + username + "!</h1>");
            pw.write(" Session id: " + request.getSession().getId());
            pw.write(" <br><br> Cookies List: <br> ");
            if (cookies!=null){
                for (Cookie index:cookies) {
                    pw.write("Cookie name: " + index.getName() + " -> "
                                + "Cookie value: " + index.getValue() + " <br> ");
                }
            }
            else
                pw.write("Cookie list is empty!");
        }
        else{
            PrintWriter pw = response.getWriter();
            pw.write("Wrong username and password! <br>");
            request.getSession().setAttribute("user",username);
            request.getSession().setAttribute("session", request.getSession());
            pw.write("User: " + username + " <br> Session id: " + request.getSession().getId());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/loginFail.jsp");

            requestDispatcher.forward(request,response);

        }

    }

}
