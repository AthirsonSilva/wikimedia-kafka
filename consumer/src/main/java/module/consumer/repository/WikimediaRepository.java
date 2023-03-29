package module.consumer.repository;

import module.consumer.entity.WikimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaEntity, UUID> {
}
