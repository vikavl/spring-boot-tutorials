package vikavl.h2docker.model.entity;

import lombok.Data;

@Data
public class MessageRequest {
    private String message;
    private String type;
}
