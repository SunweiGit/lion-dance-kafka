package cn.liondance.liondancekafka;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "KafkaSender")
@RestController
@Slf4j
@AllArgsConstructor
public class KafkaSender {

    //自定义topic
    public static final String        TOPIC_ONE = "topic.one";
    private final       KafkaTemplate kafkaTemplate;

    @GetMapping(value = "send")
    public void send(String obj) {
        log.info("准备发送消息为：{}", obj);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_ONE, obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TOPIC_ONE + " - 生产者 发送消息失败：" + throwable.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(TOPIC_ONE + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });


    }
}