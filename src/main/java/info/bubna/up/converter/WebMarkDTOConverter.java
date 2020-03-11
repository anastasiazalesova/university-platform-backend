package info.bubna.up.converter;

import info.bubna.up.dto.WebMarkDTO;
import info.bubna.up.dto.db.RecMarkWithDisciplineNameAndTeacherName;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WebMarkDTOConverter
        implements Converter<RecMarkWithDisciplineNameAndTeacherName, WebMarkDTO> {

    @Override
    public WebMarkDTO convert(RecMarkWithDisciplineNameAndTeacherName from) {
        return WebMarkDTO.builder()
                .id(from.getId())
                .value(from.getValue().intValue())
                .disciplineName(from.getDisciplineName())
                .teacherName(from.getTeacherFirstName() + " " + from.getTeacherLastName())
                .date(from.getDate())
                .build();
    }
}
