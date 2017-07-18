package ro.teamnet.zth.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Claudiu.Brandabur on 18-Jul-17.
 */
public class InfoHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Enumeration<String> allHeaders = request.getHeaderNames();
        Enumeration<String> allValues = null;

        String table = "<p>" + "Metoda: " + request.getMethod() + "</p>";

        table += "<p>" + "Query String: " + request.getQueryString() + "</p>";

        table += "<br> <table style=\"width:100%\"> <tr><th>Header</th><th>Values</th></tr>";

        while (allHeaders.hasMoreElements()){
            table += "<tr>";
            table += "<td>";
            String currentHeader = allHeaders.nextElement();
            table += currentHeader + "</td>";
            allValues = request.getHeaders(currentHeader);

            while (allValues.hasMoreElements()){
                table +="<td>";
                String currentValue = allValues.nextElement();
                table +=currentValue + "</td>";
            }

            table += "</tr>";
        }

        table +="</table>";

        table +="<table style=\"width:100%\"> <tr><th>Parameters</th><th>Values</th></tr>";

        Enumeration<String> allParams = request.getParameterNames();
        String allVals = null;

        while (allParams.hasMoreElements()){
            table += "<tr>";
            table += "<td>";
            String currentParam = allParams.nextElement();
            table += currentParam + "</td>";
            allVals = request.getParameter(currentParam);
            table +="<td>";
            table +=allVals + "</td>";
            table += "</tr>";
        }

        table +="</table>";

        PrintWriter PrintWriter = response.getWriter();
        PrintWriter.write(table);

    }

}
