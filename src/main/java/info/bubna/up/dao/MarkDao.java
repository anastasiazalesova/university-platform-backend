package info.bubna.up.dao;

import info.bubna.up.dto.db.RecMarkWithDisciplineNameAndTeacherName;
import info.bubna.up.gen.tables.daos.RecMarkDao;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static info.bubna.up.gen.tables.RecDiscipline.REC_DISCIPLINE;
import static info.bubna.up.gen.tables.RecMark.REC_MARK;
import static info.bubna.up.gen.tables.RecStudentBook.REC_STUDENT_BOOK;
import static info.bubna.up.gen.tables.RecUser.REC_USER;

@Repository
@RequiredArgsConstructor
public class MarkDao {

    private final DSLContext dsl;
    @Delegate
    private final RecMarkDao markDao;

    public List<RecMarkWithDisciplineNameAndTeacherName> fetchByUserId(UUID userId) {
        return
                dsl.select(
                        REC_MARK.ID.as("id"),
                        REC_MARK.VALUE.as("value"),
                        REC_DISCIPLINE.NAME.as("disciplineName"),
                        REC_USER.FIRST_NAME.as("teacherFirstName"),
                        REC_USER.LAST_NAME.as("teacherLastName"),
                        REC_MARK.DATE.as("date")
                ).from(REC_MARK)
                        .join(REC_STUDENT_BOOK).on(REC_STUDENT_BOOK.ID.eq(REC_MARK.STUDENT_BOOK_ID))
                        .join(REC_DISCIPLINE).on(REC_MARK.DISCIPLINE_ID.eq(REC_DISCIPLINE.ID))
                        .join(REC_USER).on(REC_USER.ID.eq(REC_MARK.TEACHER_ID))
                        .where(REC_STUDENT_BOOK.STUDENT_ID.eq(userId))
                        .fetchInto(RecMarkWithDisciplineNameAndTeacherName.class);
    }
}
