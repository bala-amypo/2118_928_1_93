package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/hello-servlet")
public class SimpleHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.getWriter().write("Hello Servlet Working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
