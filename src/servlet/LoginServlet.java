package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet.LoginServlet")
public class LoginServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
////        System.out.println("name:  " + name);
//        String html = null;
//        if ("admin".equals(name) && "123".equals(password)) {
//            html = "<div style='color:green'>登陆成功</div>";
//        } else {
//            html = "<div style='color:red'>登陆失败</div>";
//        }
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter pw = response.getWriter();
//        pw.println(html);
//    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());


        if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("success.html").forward(request, resp);
        } else {
            resp.sendRedirect("fail.html");
        }
    }
}
