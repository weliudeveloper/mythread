package com.liuwei.rabbitmq.topic;

import com.liuwei.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 17:18
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics", "topic");
        String routingKey = "message.update";
        channel.basicPublish("topics", routingKey, null, ("发送的" + routingKey).getBytes());

        channel.close();
        connection.close();
    }
}
