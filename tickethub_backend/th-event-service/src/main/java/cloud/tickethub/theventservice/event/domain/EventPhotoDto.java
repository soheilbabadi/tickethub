package cloud.tickethub.theventservice.event.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventPhotoDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 1092605172665585491L;

    private String id;

    private char[] fileContent;

    private String contentType;

    private String originalPhotoName;

    private long photoSize;

    private String createdBy;

    private long eventId;



}
