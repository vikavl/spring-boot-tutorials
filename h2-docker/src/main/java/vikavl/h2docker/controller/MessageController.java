package vikavl.h2docker.controller;

import org.springframework.web.bind.annotation.*;
import vikavl.h2docker.model.dto.MessageDTO;
import vikavl.h2docker.model.entity.MessageRequest;
import vikavl.h2docker.model.mapper.MessageMapper;
import vikavl.h2docker.model.mapper.MessageMapperImpl;
import vikavl.h2docker.model.repo.MessageDTORepo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {
    private final MessageDTORepo messageRepo;
    private MessageMapper messageMapper;

    public MessageController(MessageDTORepo messageRepo) {
        this.messageRepo = messageRepo;
        this.messageMapper = new MessageMapperImpl();
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMessage(@RequestBody MessageRequest message) {
        System.out.println(message);
        return messageRepo.save(messageMapper.fromMessageRequestToMessageDTO(message)).toString();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<String> searchByType(@RequestParam(name = "type") String type) {
        System.out.println(type);
        List<MessageDTO> messages = messageRepo.findByType(type);
        List<String> response = new ArrayList<>();
        messages.forEach( (m) -> { response.add(m.toString()); } );
        return response;
    }

}
