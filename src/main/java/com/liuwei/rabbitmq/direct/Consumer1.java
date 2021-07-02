package com.liuwei.rabbitmq.direct;

import com.liuwei.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 15:33
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory consumerFactory = RabbitMQUtils.getConnectionFactory();

        Connection connection = consumerFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);//设置每次只消费一条消息
        channel.queueDeclare("hello", true, false, false, null);
        String hello = channel.basicConsume("hello", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] message) throws IOException {
                System.out.println("消费者1消费了：" + new String(message));
                try {
                    TimeUnit.SECONDS.sleep(1);
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e) {

                }
            }
        });
    }
}
