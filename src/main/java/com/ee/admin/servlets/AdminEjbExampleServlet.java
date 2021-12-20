package com.ee.admin.servlets;

import com.ee.admin.ejb.AdminEjbExample;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.*;
import jakarta.transaction.RollbackException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

@WebServlet(name = "adminEjbExample", urlPatterns = "/adminEjbExample")
public class AdminEjbExampleServlet extends HttpServlet {
    @EJB
    AdminEjbExample adminEjbExample;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminEjbExample.doo();
        resp.getWriter().println("You are logged");
        StringWriter stringWriter = this.getJsonWriter();
        System.out.println(stringWriter);
        FileWriter fileWriter = new FileWriter("Student.json");
        System.out.println(fileWriter);
        fileWriter.write(stringWriter.toString());
        fileWriter.close();
    }

    public StringWriter getJsonWriter () {
        StringWriter stringWriter = new StringWriter();
        JsonGenerator generator = Json.createGenerator(stringWriter);
        generator
                .writeStartObject()
                .writeStartObject("Student")
                .write("name", "Victor")
                .write("age", 33)
                .writeStartObject("Address")
                .write("city", "Ternopil")
                .write("Street", "Troleybusna")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .close();

        return stringWriter;
    }
}
