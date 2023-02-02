package vikavl.h2docker.model.mapper;

import vikavl.h2docker.model.dto.MessageDTO;
import vikavl.h2docker.model.entity.MessageRequest;

public interface MessageMapper {
    MessageDTO fromMessageRequestToMessageDTO(MessageRequest message);
}
