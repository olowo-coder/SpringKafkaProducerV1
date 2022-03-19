package com.example.springkafkaproducerv1.controller;

import com.example.springkafkaproducerv1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    @GetMapping("/publish/{message}")
    public Object publishOldMessage(@PathVariable final String message){
//        kafkaTemplate.send(TOPIC, message);
        return Map.of("one", "Publish Successfully");
    }

    @PostMapping("/publish")
    public Object publishMessage(@RequestBody Book book){
        kafkaTemplate.send(TOPIC, book);
        return Map.of("status", "Publish Successfully");
    }
}