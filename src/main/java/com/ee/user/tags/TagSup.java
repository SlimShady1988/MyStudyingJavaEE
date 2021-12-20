package com.ee.user.tags;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;


public class TagSup extends SimpleTagSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws IOException, JspException {
        JspWriter out = getJspContext().getOut();
        out.print("JSP TAG");
        out.print(name);
        StringWriter stringWriter = new StringWriter();
        getJspBody().invoke(stringWriter);
        out.print("<b>");
        out.print(stringWriter.toString());
        out.print("</b>");

        getJspContext().setAttribute("nameFromAttribute", "Attribute Victor");
    }

    public static int minus(int a, int b) {
        return a - b;
    }
}
