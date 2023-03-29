package module.producer.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Value("${spring.kafka.producer.topic}")
    public String topic;

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(topic)
                .build();
    }
}
