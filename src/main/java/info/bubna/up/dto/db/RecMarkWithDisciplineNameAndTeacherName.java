package info.bubna.up.dto.db;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.sql.Timestamp;
import java.util.UUID;

@Value
@Builder
@RequiredArgsConstructor
public class RecMarkWithDisciplineNameAndTeacherName {
    private final UUID id;

    private final Short value;

    private final String disciplineName;

    private final String teacherFirstName;

    private final String teacherLastName;

    private final Timestamp date;
}
