create table LINK_DISCIPLINE_GROUP
(
    id            uuid primary key,
    discipline_id uuid references university_platform.REC_DISCIPLINE (id),
    group_id      uuid references university_platform.REC_GROUP (id)
);