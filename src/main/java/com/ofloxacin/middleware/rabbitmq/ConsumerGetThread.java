package com.ofloxacin.middleware.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import lombok.SneakyThrows;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-08-03
 */
public class ConsumerGetThread implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        channel.exchangeDeclare(RabbitTest.EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true);
        channel.queueDeclare(RabbitTest.QUEUE_NAME, true, false, false, null);
        channel.queueBind(RabbitTest.QUEUE_NAME, RabbitTest.EXCHANGE_NAME, RabbitTest.ROUTING_KEY);
        while (true) {
            GetResponse response = channel.basicGet(RabbitTest.QUEUE_NAME, false);
            if (response == null) {
                Thread.sleep(1000);
                continue;
            }
            System.out.println(response.getEnvelope());
            channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
        }
    }
}
