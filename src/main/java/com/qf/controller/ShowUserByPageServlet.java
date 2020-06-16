package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "ShowUserByPageServlet" ,urlPatterns = "/showUserByPageServlet")
public class ShowUserByPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Integer pageNum = getPageNum(request.getParameter("pageNum"));
        //123456
        UserService userService = new UserServiceImpl();
        PageInfo pageInfo = userService.getPageInfo(pageNum, 2);
        //System.out.println(pageInfo);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    private Integer getPageNum(String pageNumStr) {
        if (pageNumStr == null && !"".equals(pageNumStr)) return 1;
        return Integer.parseInt(pageNumStr);
    }
}
