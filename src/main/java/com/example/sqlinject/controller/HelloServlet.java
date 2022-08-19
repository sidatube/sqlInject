package com.example.sqlinject.controller;

import com.example.sqlinject.entity.User;
import com.example.sqlinject.model.UserModel;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel userModel = new UserModel();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userModel.getUser(username, password);
        if (user != null) {
            response.sendRedirect("index.jsp");
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}