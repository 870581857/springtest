package com.xf.activemq.mq1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by DCJS
 * 2019/5/27.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //创建一个mq的连接工厂
        ConnectionFactory factory
                = new ActiveMQConnectionFactory("tcp://192.168.1.102:61616");
        //获得一个连接
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建一个session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个队列队形
        Queue tx_queue = session.createQueue("tx_queue");
        //创建消息的消费者
        MessageConsumer consumer = session.createConsumer(tx_queue);
        //接受一个消息
        TextMessage message = (TextMessage) consumer.receive();
        String text = message.getText();
        System.out.println(text);
        session.close();
        connection.close();
    }
}
