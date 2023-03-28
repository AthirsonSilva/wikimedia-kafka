package module.producer.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
public class WikimediaChangesHandler implements EventHandler {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("Received message --> %s", messageEvent.getData()));

        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String comment) throws Exception {

    }

    @Override
    public void onError(Throwable t) {

    }
}
