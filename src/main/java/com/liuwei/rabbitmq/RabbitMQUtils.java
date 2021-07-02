package com.liuwei.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author wee
 * @Description:
 * @date 2021/2/4 11:49
 */
public class RabbitMQUtils {

    public static ConnectionFactory getConnectionFactory() {
        ConnectionFactory consumerFactory = new ConnectionFactory();
        consumerFactory.setHost("127.0.0.1");
        consumerFactory.setPort(5672);
        consumerFactory.setVirtualHost("/wee");
        consumerFactory.setUsername("wee");
        consumerFactory.setPassword("123");
        return consumerFactory;
    }


}
