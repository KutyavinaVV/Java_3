package ru.kpfu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by promoscow on 17.07.17.
 */
public class SimpleServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("title", "New Title");
    request. setAttribute("content", "something interesting");
    request.getRequestDispatcher("/WEB-INF/layout.jsp").forward(request, response);
  }
}