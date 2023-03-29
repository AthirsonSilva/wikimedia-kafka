package module.consumer.repository;

import module.consumer.entity.WikimediaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends MongoRepository<WikimediaData, String> {
}
