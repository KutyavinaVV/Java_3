package ru.kpfu.servlets;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@WebServlet("/reg")
public class SimpleServlet extends HttpServlet{

  private static String PATH = "C:\\Users\\днс\\Desktop\\kfu-programming-java3-master\\servletExampleFirst\\src\\main\\java\\ru\\kpfu\\servlets\\Data.csv";
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try (PrintWriter out = resp.getWriter()) {
      out.println(getPageCode1(""));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    String password = req.getParameter("psw");
    String password_repeat = req.getParameter("psw-repeat");
    try (PrintWriter out = resp.getWriter();   CSVWriter writer = new CSVWriter(new FileWriter(PATH, true))) {
      if (name.isEmpty()) {
        out.println(getPageCode1("Wrong Name"));
        return;
      }
      if (!checkEmail(email)) {
        out.println(getPageCode1("Wrong email"));
        return;
      }
      if (!password.equals(password_repeat)) {
        out.println(getPageCode1("Wrong password"));
        return;
      }
      String [] data = {name, email, Integer.toString(password.hashCode())};
      writer.writeNext(data);
      String greetings = "success!";
      writer.flush();
      out.println(getPageCode2(greetings));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  

  protected String getPageCode1(String string){
    return "<!DOCTYPE html><html>"
            + "<head><meta charset='UTF-8'><title>Registration</title></head>"
            + "<body>"
            + string
            + "<form action='' method='POST'><input class=\"row\" type=\"text\" placeholder=\"Enter Name\" name=\"name\" required><br>" +
            "<input class=\"row\"  type=\"text\" placeholder=\"Enter Email\" name=\"email\" required><br>" +
            "<input class=\"row\"  type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required><br>" +
            "<input  class=\"row\"  type=\"password\" placeholder=\"Repeat Password\" name=\"psw-repeat\" required><br>" +
            "<input type=\"checkbox\" checked>\n " +
            "        Terms of agreement <br> <input type='submit' value='Okey'></form>"
            + "</body></html>";
  }

  protected String getPageCode2(String content){
    return "<!DOCTYPE html><html>"
            + "<head><meta charset='UTF-8'><title>Hello page</title></head>"
            + "<body>"
            + content
            + "</body></html>";
  }

  protected boolean checkEmail (String email) {
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    return pattern.matcher(email).matches();
  }
}
