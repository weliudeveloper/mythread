package com.liuwei.rabbitmq.routing;

import com.liuwei.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 16:43
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare("logs_direct", "direct");

        String routingKey = "error";
        channel.basicPublish("logs_direct", routingKey, null, ("订阅的消息" + routingKey).getBytes());

        channel.close();
        connection.close();
    }
}
