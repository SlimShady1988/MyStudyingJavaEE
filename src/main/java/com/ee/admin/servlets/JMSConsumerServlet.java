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
import java.io.IOException;

@WebServlet(name = "consumerServlet", urlPatterns = "/consumerServlet")
public class JMSConsumerServlet extends HttpServlet {
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
        //            MessageConsumer consumer = (MessageConsumer) session.createConsumer(queue);
        //            TextMessage textMessage = (TextMessage) consumer.receive();
        //            resp.getWriter().write(textMessage.getText());
        //        } catch (JMSException e) {
        //            e.printStackTrace();
        //        }
        // #############################         Variant 1       #############################

        // #############################         Variant 4       #############################
        try {
            JMSContext context = connectionFactory.createContext();
            JMSConsumer consumer = context.createConsumer(queue);
            TextMessage textMessage = (TextMessage)consumer.receive();
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(message.getBody(String.class));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            resp.getWriter().write(textMessage.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }

        // #############################         Variant 4      #############################

        // #############################         Variant 5       #############################
//            resp.getWriter().write(context.createConsumer(queue).receiveBody(String.class));
            // #############################         Variant 5       #############################



    }
}
