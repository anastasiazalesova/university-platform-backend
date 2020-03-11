insert into university_platform.rec_course
values (md5(random()::text || clock_timestamp()::text)::uuid, 'test_course');

insert into university_platform.rec_module
values (md5(random()::text || clock_timestamp()::text)::uuid, 'test_module',
        (select id from university_platform.rec_course where rec_course.name = 'test_course'));

insert into university_platform.REC_DISCIPLINE
values (md5(random()::text || clock_timestamp()::text)::uuid, 'test_discipline',
        (select id from university_platform.rec_module where rec_module.name = 'test_module'));

insert into university_platform.rec_group
values (md5(random()::text || clock_timestamp()::text)::uuid, 'test_group');

insert into university_platform.LINK_DISCIPLINE_GROUP
values (md5(random()::text || clock_timestamp()::text)::uuid,
        (select id from university_platform.REC_DISCIPLINE where REC_DISCIPLINE.name = 'test_discipline'),
        (select id from university_platform.rec_group where rec_group.name = 'test_group'));

insert into university_platform.LINK_STUDENT_GROUP
values (md5(random()::text || clock_timestamp()::text)::uuid,
        (select id from university_platform.rec_user where rec_user.first_name = 'fAdmin'),
        (select id from university_platform.rec_group where rec_group.name = 'test_group'));

insert into university_platform.rec_credentials
values (md5(random()::text || clock_timestamp()::text)::uuid, 'teacher', 'teacher');

insert into university_platform.rec_user
values (md5(random()::text || clock_timestamp()::text)::uuid, 'fTeacher', 'lTeacher',
        (select id from university_platform.rec_role where name = 'role_admin'),
        (select id from university_platform.rec_credentials where login = 'teacher'));

insert into university_platform.rec_student_book
values (md5(random()::text || clock_timestamp()::text)::uuid,
        (select id from university_platform.rec_user where rec_user.first_name = 'fAdmin'));

insert into university_platform.rec_mark
values (md5(random()::text || clock_timestamp()::text)::uuid, '5',
        (select id from university_platform.REC_DISCIPLINE where REC_DISCIPLINE.name = 'test_discipline'),
        (select rec_student_book.id
         from university_platform.rec_student_book
                  join university_platform.rec_user
                       on rec_user.id =
                          (select id from university_platform.rec_user where rec_user.first_name = 'fAdmin')),
        (select id from university_platform.rec_user where rec_user.first_name = 'fTeacher'),
        now());