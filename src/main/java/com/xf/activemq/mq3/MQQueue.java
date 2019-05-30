package com.xf.activemq.mq3;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by XF
 * 2019/5/29.
 * https://blog.csdn.net/qq_33404395/article/details/80590113
 */
public class MQQueue {
    public static void main(String[] args) {

        MQQueue mqQueue = new MQQueue();

        try {
            mqQueue.testMQProducerQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            mqQueue.testMQConsumerQueue();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void testMQProducerQueue() throws Exception{
        //创建工厂连接对象,需要定制ip和端口
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.76.128:61616");
        //使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //使用连接对象创建会话(session)对象
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //使用会话对象创建目标对象，,包含queue和topic(一对一和一对多)
        Queue queue = session.createQueue("test-queue");
        //使用会话对象创建生产者
        MessageProducer producer = session.createProducer(queue);
        //使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hello!test-queue");
        //发送消息
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void testMQConsumerQueue() throws Exception{
        //创建工厂连接对象
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.76.128:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("test-queue");
        MessageConsumer consumer = session.createConsumer(queue);

//        TextMessage message = (TextMessage) consumer.receive();
//        String text = message.getText();
//        System.out.println(text);

        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //*** messageListener 监听器是异步的 可能还没有接收到消息程序就退出了 所以延时
        //Thread.sleep(5000);
        System.in.read();

        consumer.close();
        session.close();
        connection.close();
    }
}
