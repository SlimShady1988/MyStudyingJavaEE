package com.ee.user.servlets;

import com.ee.user.model.User;
import com.ee.user.model.UserRepository;
import jakarta.ejb.EJB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userslistfromdb", urlPatterns = "/userlistfromdb")
public class EjbServlet extends HttpServlet {
//    @PersistenceUnit
//    EntityManagerFactory emf;
    @EJB
    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        EntityManager em = emf.createEntityManager();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = RandomStringUtils.randomAlphabetic(10);
            String surname = RandomStringUtils.randomAlphabetic(8);
            double generatedAge = Math.random() * 50;
            int age = (int) Math.round(generatedAge);
            list.add(new User(name, surname, age));
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("USERS LIST:");

        if (req.getParameter("create") != null) {
            userRepository.createUser(new User("Victor", "Nazarkiv", 33));
            out.println("<ul>");
            out.println("<li> User was successfully created</li>");
            out.println("<li> Name - " + userRepository.readUser(11).getName() +
                    ",  Surname - " + userRepository.readUser(11).getSurname() +
                    ", Age - " + userRepository.readUser(11).getAge() + "</li>");
            out.println("</ul>");
        } else if (req.getParameter("read") != null) {
            out.println("<ul>");
            out.println("<li> You selected this user - </li>");
            out.println("<li> Name - " + userRepository.readUser(11).getName() +
                    ",  Surname - " + userRepository.readUser(11).getSurname() +
                    ", Age - " + userRepository.readUser(11).getAge() + "</li>");
            out.println("</ul>");
        } else if (req.getParameter("update") != null) {
            out.println("<ul>");
            out.println("<li> You successfully was updated user - </li>");
            out.println("<li> Name - " + userRepository.readUser(11).getName() +
                    ",  Surname - " + userRepository.readUser(11).getSurname() +
                    ", Age - " + userRepository.readUser(11).getAge() + "</li>");
            out.println("<li> and now it is - </li>");
            userRepository.updateUser(11, "Oksana", "Nazarkiv", 29);
            out.println("<li> Name - " + userRepository.readUser(11).getName() +
                    ",  Surname - " + userRepository.readUser(11).getSurname() +
                    ", Age - " + userRepository.readUser(11).getAge() + "</li>");
            out.println("</ul>");
        } else if (req.getParameter("delete") != null) {
            out.println("<ul>");
            out.println("<li> User was successfully deleted - </li>");
            userRepository.removeUser(11);
            out.println("</ul>");
        } else if (req.getParameter("updateThreads") != null) {
            new Thread() {
                @Override
                public void run() {
                    User userTh = userRepository.readUser(11);
                    userRepository.updateUser(11, userTh.getName()+"Oksana", "Nazarkiv", 22);
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    User userTh = userRepository.readUser(11);
                    userRepository.updateUser(11, userTh.getName()+"Xenya", "Nazarkiv", 29);
                }
            }.start();
        } else if (req.getParameter("deleteAll") != null) {
            out.println("<ul>");
            out.println("<li> User table was successfully deleted - </li>");
            userRepository.clearUserTable();
            out.println("</ul>");
        } else {
            for (User user : list) {
                userRepository.createUser(user);
                out.println("<ul>");
                out.println("<li> Name - " + user.getName() + ",  Surname " + user.getSurname() + ", Age - " + user.getAge() + "</li>");
                out.println("</ul>");
            }
        }

        out.println("<a href=" + "/javaee-1/userlistfromdb?create=true" + ">Create</a>");
        out.println("<a href=" + "/javaee-1/userlistfromdb?read=true" + ">Read</a>");
        out.println("<a href=" + "/javaee-1/userlistfromdb?update=true" + ">Update</a>");
        out.println("<a href=" + "/javaee-1/userlistfromdb?delete=true" + ">Delete</a>");
        out.println("<a href=" + "/javaee-1/userlistfromdb?deleteAll=true" + ">DeleteAll</a>");
        out.println("<a href=" + "/javaee-1/userlistfromdb?updateThreads=true" + ">updateThreads</a>");
        out.println("</body></html>");
        out.println("<br>");
        out.println("JPQL LIST - ");
        List<User> listJpqlselect = userRepository.jpqlSelect();
        for (User userJpql : listJpqlselect) {
            out.println("<br>");
            out.println( userJpql.getName()+" "+userJpql.getSurname()+" "+userJpql.getAge()+" ");
        }

        out.println("<br>");
        out.println("<br>");
        out.println("JPQL  Created user- ");
        List<User> listJpqlcreate = userRepository.jpqlcreate();
        for (User created : listJpqlcreate) {
            out.println("<br>");
            out.println( created.getName()+" "+created.getSurname()+" "+created.getAge()+" ");
        }
        out.println("<br>");
        out.println("<br>");



//        out.println("@Named Stored Procedur - ");
//        String str =  userRepository.namedStoredEx(11, 33);
//        out.println(str);
//
//        out.println("<br>");
//        out.println("<br>");




//        resp.getWriter().write("Done");
    }
}
