package cloud.tickethub.theventservice.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class KeyValDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -6691833705758226395L;

    private long id;
    private String title;
}
