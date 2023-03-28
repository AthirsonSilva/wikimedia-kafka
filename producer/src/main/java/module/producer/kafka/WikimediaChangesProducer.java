package module.producer.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class WikimediaChangesProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce() throws InterruptedException {
        LOGGER.info("Producing...");

        String topic = "wikimedia_recent_change";
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        final String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
