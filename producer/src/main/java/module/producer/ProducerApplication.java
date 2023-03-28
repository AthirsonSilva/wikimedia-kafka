package module.producer;

import lombok.RequiredArgsConstructor;
import module.producer.kafka.WikimediaChangesProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ProducerApplication implements CommandLineRunner {
	private final WikimediaChangesProducer wikimediaChangesProducer;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.produce();
	}
}
