package ru.kpfu.servlets;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class MyFormTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<input class=\"row\"  type=\"text\" placeholder=\"Enter Email\" name=\"email\" required><br>");
    }


}
