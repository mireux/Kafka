package com.example.springboot.kafka.porducer;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author mireux
 */
@RestController
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @GetMapping("/kafka/test/{msg}")
    public void sendMessage(@PathVariable("msg") String msg) {
        kafkaTemplate.send("testTopic", msg);
        System.out.println("success");
    }

    @GetMapping("/es/test")
    public void getEsData() throws IOException {

        SearchResponse<Object> search = elasticsearchClient.search(s -> s.index("products")
                .query(q -> q.term(t -> t.field("title").value("Iphone XR"))), Object.class);
        System.out.println(search);
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
