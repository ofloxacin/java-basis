package com.ofloxacin.middleware.rabbitmq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-08-03
 */
public class RabbitTest {

    public static final String EXCHANGE_NAME = "mineExc";

    public static final String QUEUE_NAME = "mineQueue";

    public static final String ROUTING_KEY = "mineRoutingKey";

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new ConsumerThread());
        executorService.execute(new PublisherThread());
        //executorService.execute(new ConsumerGetThread());
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
