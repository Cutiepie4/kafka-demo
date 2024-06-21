package com.viet.kafka.kafkaproducer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    private final KafkaTopicModel kafkaTopicModel;
    private final String bootstrapAddress;

    public KafkaTopicConfig(KafkaTopicModel kafkaTopicModel,
                            @Value("${spring.kafka.bootstrap-servers}") String bootstrapAddress) {
        this.kafkaTopicModel = kafkaTopicModel;
        this.bootstrapAddress = bootstrapAddress;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic nameTopic() {
        return TopicBuilder.name(kafkaTopicModel.getNameTopic()).build();
    }

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder.name(kafkaTopicModel.getMessageTopic()).build();
    }
}

