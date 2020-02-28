package info.bubna.up.dao;

import info.bubna.up.gen.tables.daos.RecDisciplineDao;
import info.bubna.up.gen.tables.pojos.RecDiscipline;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static info.bubna.up.gen.tables.LinkDisciplineGroup.LINK_DISCIPLINE_GROUP;
import static info.bubna.up.gen.tables.LinkStudentGroup.LINK_STUDENT_GROUP;
import static info.bubna.up.gen.tables.RecDiscipline.REC_DISCIPLINE;

@Repository
@RequiredArgsConstructor
public class DisciplineDao {

    private final DSLContext dsl;
    @Delegate
    private final RecDisciplineDao disciplineDao;

    public List<RecDiscipline> fetchByUserId(UUID userId) {
        return dsl.select().from(REC_DISCIPLINE)
                .join(LINK_STUDENT_GROUP).on(LINK_STUDENT_GROUP.USER_ID.eq(userId))
                .join(LINK_DISCIPLINE_GROUP).on(LINK_STUDENT_GROUP.GROUP_ID.eq(LINK_DISCIPLINE_GROUP.GROUP_ID))
                .fetchInto(RecDiscipline.class);
    }
}
