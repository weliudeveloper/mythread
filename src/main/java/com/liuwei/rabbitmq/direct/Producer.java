package com.liuwei.rabbitmq.direct;

import com.liuwei.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 10:19
 */
public class Producer {

    @Test
    public void testProducer() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = RabbitMQUtils.getConnectionFactory();

        //创建本次连接
        Connection connection = factory.newConnection();
        //创建本次连接通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare("hello", true, false, false, null);

        for (int i = 0; i < 20; i++) {
            //往已经存在的队列里面发送消息
            channel.basicPublish("", "hello", false, null, (i + "hello World").getBytes());
        }

        //关闭资源
        channel.close();
        connection.close();
    }

}
