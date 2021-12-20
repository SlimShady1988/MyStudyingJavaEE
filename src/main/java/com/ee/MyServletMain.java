package com.ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "MyServletMain", urlPatterns = "/main"
        , asyncSupported = true
)
public class MyServletMain extends HttpServlet {

    private static final long serialVersionUID = 1533534214224427354L;
    private final Map<Integer, String> users = new ConcurrentHashMap<Integer,String>();
    private AtomicInteger counter;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = 0;
        String name = req.getParameter("name");

        if (!users.containsValue(name)) {
            System.out.println("==Contains==");
            id = counter.incrementAndGet();
            users.put(id, name);
        }

        resp.setContentType("text/html;charset=utf-8");
        if (id==0) {
            System.out.println("user with name exist ");
        } else {
            System.out.println("user " + name + " is  Created ");
        }

//        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        users.put(1, "Ivan");
        users.put(2, "Stepan");
        users.put(3, "Petro");
        this.counter = new AtomicInteger(3);
        System.out.println("Initialization Servlet");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")!= null) {
            int id = Integer.parseInt(req.getParameter("id"));
        }

        Map<String, Integer> persons = new HashMap<>();
        persons.put("Mary", 20);
        persons.put("John", 30);
        persons.put("Sem", 40);
        req.setAttribute("persons", persons);

//                                                         ************  ASYNC REQUESTS  *************
//        AsyncContext asyncContext = req.getAsyncContext();
//        asyncContext.start(() -> {
            // do some code what will be working asynchronous
//        });
//        asyncContext.complete();

        req.getRequestDispatcher("main.jsp").forward(req,resp);
    }
}
