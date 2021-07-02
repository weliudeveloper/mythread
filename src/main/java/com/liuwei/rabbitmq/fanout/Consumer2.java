package com.liuwei.rabbitmq.fanout;

import com.liuwei.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 16:01
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = channel.queueDeclare().getQueue();//临时队列的名称
        //生成交换机
        channel.exchangeDeclare("logs", "fanout");
        //绑定交换机和队列
        channel.queueBind(queueName, "logs", "");
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2消费： " + new String(body));
            }
        });
    }
}
