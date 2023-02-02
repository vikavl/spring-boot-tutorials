package vikavl.h2docker.model.mapper;

import vikavl.h2docker.model.dto.MessageDTO;
import vikavl.h2docker.model.entity.MessageRequest;

import java.util.UUID;

public class MessageMapperImpl implements MessageMapper {
    @Override
    public MessageDTO fromMessageRequestToMessageDTO(MessageRequest message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(UUID.randomUUID().toString());
        messageDTO.setMessage(message.getMessage());
        messageDTO.setType(message.getType());
        return messageDTO;
    }
}
