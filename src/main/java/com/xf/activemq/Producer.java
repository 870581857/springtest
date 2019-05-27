package com.xf.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by DCJS
 * 2019/5/27.
 */
public class Producer {
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
        //创建消息的生产者
        MessageProducer producer = session.createProducer(tx_queue);
        //创建一个消息
        TextMessage message = session.createTextMessage("hello world");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
