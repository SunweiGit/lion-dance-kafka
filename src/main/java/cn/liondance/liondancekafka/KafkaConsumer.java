package cn.liondance.liondancekafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消费者
 *
 * @author ：zhangqiang
 * @create ：2018-09-05 17:17
 **/
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaSender.TOPIC_ONE, groupId = "topic_one")
    public void topic_one(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("被topic_one消费了： +++++++++++++++ Topic:" + topic + ",Record:" + record + ",Message:" + msg);
        }
    }

    @KafkaListener(topics = KafkaSender.TOPIC_ONE, groupId = "topic_one")
    public void topic_one1(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("被topic_one1消费了： +++++++++++++++ Topic:" + topic + ",Record:" + record + ",Message:" + msg);
        }
    }


}