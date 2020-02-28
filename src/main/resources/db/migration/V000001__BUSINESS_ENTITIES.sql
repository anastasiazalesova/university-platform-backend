create table REC_GROUP
(
    id   uuid primary key,
    name varchar
);

create table LINK_STUDENT_GROUP
(
    id       uuid primary key,
    user_id  uuid references university_platform.REC_USER (id),
    group_id uuid references university_platform.REC_GROUP (id)
);

create table REC_COURSE
(
    id   uuid primary key,
    name varchar
);

create table REC_MODULE
(
    id        uuid primary key,
    name      varchar,
    course_id uuid references university_platform.REC_COURSE (id)
);

create table REC_DISCIPLINE
(
    id        uuid primary key,
    name      varchar,
    module_id uuid references university_platform.REC_MODULE (id)
);

create table REC_STUDENT_BOOK
(
    id         uuid primary key,
    student_id uuid references university_platform.REC_USER (id)
);

create table REC_MARK
(
    id              uuid primary key,
    value           smallint,
    discipline_id   uuid references university_platform.REC_DISCIPLINE (id),
    student_book_id uuid references university_platform.REC_STUDENT_BOOK (id),
    teacher_id      uuid references university_platform.REC_USER (id),
    date            timestamp
);