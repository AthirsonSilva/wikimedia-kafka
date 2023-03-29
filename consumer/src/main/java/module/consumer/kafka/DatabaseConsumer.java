package module.consumer.kafka;

import lombok.RequiredArgsConstructor;
import module.consumer.entity.WikimediaEntity;
import module.consumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConsumer.class);
    private final WikimediaRepository repository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        LOGGER.info(String.format("Consumed event message -> %s", message));

        WikimediaEntity wikimediaData = new WikimediaEntity();
        wikimediaData.setWikiEventData(message);

        repository.save(wikimediaData);
    }
}
