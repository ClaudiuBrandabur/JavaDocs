package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Claudiu.Brandabur on 19-Jul-17.
 */
public class HeadersLogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = null;
        String output = "";

        LogFileWriter.logHeader("dsfsd","sdfsd");
        resp.getWriter().write("<br> HELLO from HELLO WORLD FILTER!");

//        chain.doFilter(req, resp);

        /*if (req instanceof HttpServletRequest){
            request = (HttpServletRequest) req;

            Enumeration<String> headerNames = request.getHeaderNames();
            Enumeration<String> headerValues = null;
            String currentElem ;

            if (headerNames != null){
                while (headerNames.hasMoreElements()){
                    currentElem = headerNames.nextElement();
                    headerValues = request.getHeaders(currentElem);
                    if (headerValues != null){
                        while (headerValues.hasMoreElements()){
                            output +=currentElem + " -> " + String.valueOf(headerValues);
                                    //LogFileWriter.logHeader(currentElem, String.valueOf(headerValues));
                        }
                    }
                }
            }

            LogFileWriter.logHeader("", output);

        }*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
