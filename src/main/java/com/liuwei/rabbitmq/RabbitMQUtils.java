package com.liuwei.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 11:49
 */
public class RabbitMQUtils {

    public static Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }

    public static ConnectionFactory getConnectionFactory() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        return factory;
    }


}
