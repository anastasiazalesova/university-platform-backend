package info.bubna.up.converter;

import info.bubna.up.dto.WebDisciplineDTO;
import info.bubna.up.gen.tables.pojos.RecDiscipline;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WebDisciplineDTOConverter
        implements Converter<RecDiscipline, WebDisciplineDTO> {

    @Override
    public WebDisciplineDTO convert(RecDiscipline from) {
        return WebDisciplineDTO.builder()
                .id(from.getId())
                .name(from.getName())
                .build();
    }
}
