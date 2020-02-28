create table DICT_RIGHT
(
    id   uuid primary key,
    name varchar
);

create table REC_ROLE
(
    id   uuid primary key,
    name varchar
);

create table LINK_ROLE_RIGHT
(
    id       uuid primary key,
    role_id  uuid references REC_ROLE (id),
    right_id uuid references DICT_RIGHT (id)
);

create table REC_CREDENTIALS
(
    id       uuid primary key,
    login    varchar unique,
    password varchar
);

create table REC_USER
(
    id         uuid primary key,
    first_name varchar,
    last_name  varchar,
    role_id    uuid references REC_ROLE (id),
    credentials_id uuid references REC_CREDENTIALS(id)
);