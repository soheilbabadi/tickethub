package cloud.tickethub.theventservice.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventPhotoPostDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 1092605172665585491L;

    private String id;

    private String createdBy;

    private long eventId;

    private MultipartFile originalPhoto;

}
