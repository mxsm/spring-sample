package com.github.mxsm;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/3/29 18:15
 */
public class MQConsumer {

    public static void main(String[] args) throws Exception{
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("Mxsm");

        // Specify name server addresses.
        consumer.setNamesrvAddr("192.168.31.49:9876");

        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicTest", "TagB");
        consumer.subscribe("TopicTest-1", "TagB");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.println("消费时间:"+System.currentTimeMillis());
            System.out.printf("%s Receive New Messages: %s %n", System.currentTimeMillis(), Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");

        //other();
    }

    private static void other() throws Exception{
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group");

        // Specify name server addresses.
        consumer.setNamesrvAddr("192.168.31.26:9876");

        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicTest", "TagB");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
