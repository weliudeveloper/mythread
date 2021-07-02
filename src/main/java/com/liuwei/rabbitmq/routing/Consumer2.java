package com.liuwei.rabbitmq.routing;

import com.liuwei.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 16:47
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_direct", "direct");

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "logs_direct", "info");
        channel.queueBind(queueName, "logs_direct", "error");

        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2消费" + new String(body));
            }
        });
    }
}
