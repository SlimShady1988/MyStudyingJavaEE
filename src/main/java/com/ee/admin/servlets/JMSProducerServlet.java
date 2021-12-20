package com.ee.admin.servlets;

import jakarta.annotation.Resource;
import jakarta.jms.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

@WebServlet(name = "producerServlet", urlPatterns = "/producerServlet")
public class JMSProducerServlet extends HttpServlet {
    //#############################         Variant 2       #############################
//    @Resource(lookup = "openejb:Resource/myJMSConnectionFactory")
//    ConnectionFactory connectionFactory;
//    @Resource(lookup = "openejb:Resource/MyQueue")
//    Queue queue;
    //#############################         Variant 2       #############################
    //#############################         Variant 3       #############################
    @Resource
    ConnectionFactory connectionFactory;
    @Resource(name = "MyNewQueue")
    Queue queue;
    //#############################         Variant 3       #############################

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //#############################         Variant 1       #############################
        //        try {
        //            Context jndiContext = new InitialContext();
        //            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("openejb:Resource/myJMSConnectionFactory");
        //            Queue queue = (Queue) jndiContext.lookup("openejb:Resource/MyQueue");
        //            Connection connection = connectionFactory.createConnection();
        //            connection.start();
        //            Session session = connection.createSession();
        //            MessageProducer producer = session.createProducer(queue);
        //            Message msg = session.createTextMessage("Some new message  2 was sent");
        //            producer.send(msg);
        //    } catch (JMSException e) {
        //        e.printStackTrace();
        //    }
        // #############################         Variant 1       #############################

        //#############################         Variant 4       #############################
        JMSContext context = connectionFactory.createContext();
        context.createProducer().send(queue, "From Other Producer");
        // #############################         Variant 4      #############################

    }
}
