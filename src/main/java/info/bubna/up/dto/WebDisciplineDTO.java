package info.bubna.up.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class WebDisciplineDTO {
    private UUID id;
    private String name;
}
