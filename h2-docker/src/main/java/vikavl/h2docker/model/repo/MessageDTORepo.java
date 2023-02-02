package vikavl.h2docker.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vikavl.h2docker.model.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageDTORepo extends JpaRepository<MessageDTO, String> {
    List<MessageDTO> findByType(String type);

    Optional<MessageDTO> findById(String id);
}
