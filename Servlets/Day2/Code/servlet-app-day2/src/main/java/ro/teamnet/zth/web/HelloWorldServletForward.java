package ro.teamnet.zth.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Claudiu.Brandabur on 19-Jul-17.
 */
public class HelloWorldServletForward extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Object testAttribute = request.getAttribute("testAttribute");

        PrintWriter printWriter = response.getWriter();
        printWriter.write("Hello <b>user: " + request.getParameter("user") + " "
                            + "</b> from the Forward Servlet! <br> testAttribute: " + testAttribute);
    }

}
