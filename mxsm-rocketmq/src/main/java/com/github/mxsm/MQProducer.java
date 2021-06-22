package com.github.mxsm;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/3/29 18:10
 */
public class MQProducer {

    public static void main(String[] args) throws Exception {
        /* Instantiate with a producer group name. */
        DefaultMQProducer producer = new
            DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("192.168.31.49:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
            String s = "TTTTT Hello RocketMQ " +
                System.nanoTime();
            Message msg = new Message("TopicTest" /* Topic */,
                "TagB" /* Tag */,
                s.getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            msg.setDelayTimeLevel(1);
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.println("发送时间:"+System.currentTimeMillis());
            System.out.printf("%s%n", sendResult);
            System.out.println(s);

        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
