package vikavl.h2docker.model.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MessageDTO {
    @Id
    private String id;
    private String message;
    private String type;

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
