package ro.teamnet.zth.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Claudiu.Brandabur on 18-Jul-17.
 */
public class ZeroToHeroServlet extends HttpServlet {

    private String handleRequest(HttpServletRequest request) {

        String response = "Hello <b> " + request.getParameter("firstName") + " "
                            + request.getParameter("lastName") + " </b>! Enjoy Zero To Hero!!!";

        return response;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String resp = null;
        resp = handleRequest(request);

        PrintWriter printWriter = response.getWriter();
        printWriter.write( resp);
    }

}
