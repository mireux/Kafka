package com.example.springboot.kafka.consumer;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>在开始处详细描述该类的作用</p>
 *
 * @author haijie.liang@juphoon.com
 * @date 2022/11/25 10:49
 */
@Component
public class KafkaConsumer {

    @Autowired
    public ElasticsearchClient elasticsearchClient;

    @KafkaListener(topics = {"testTopic"})
    public void onMessage1(ConsumerRecord<?, ?> record) throws IOException {
        elasticsearchClient.searchShards();
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());

    }
}
