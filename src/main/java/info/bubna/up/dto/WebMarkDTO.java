package info.bubna.up.dto;

import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@Value
@Builder
public class WebMarkDTO {
    private UUID id;
    private Integer value;
    private String disciplineName;
    private String teacherName;
    private Timestamp date;
}
