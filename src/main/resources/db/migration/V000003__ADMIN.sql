insert into university_platform.dict_right
values (md5(random()::text || clock_timestamp()::text)::uuid, 'user_create'),
       (md5(random()::text || clock_timestamp()::text)::uuid, 'user_update'),
       (md5(random()::text || clock_timestamp()::text)::uuid, 'user_delete');

insert into university_platform.rec_role
values (md5(random()::text || clock_timestamp()::text)::uuid, 'role_admin');

insert into university_platform.link_role_right
values (md5(random()::text || clock_timestamp()::text)::uuid,
        (select id from university_platform.rec_role where name = 'role_admin'),
        (select id from university_platform.dict_right where name = 'user_create')),
       (md5(random()::text || clock_timestamp()::text)::uuid,
        (select id from university_platform.rec_role where name = 'role_admin'),
        (select id from university_platform.dict_right where name = 'user_update')),
       (md5(random()::text || clock_timestamp()::text)::uuid,
        (select id from university_platform.rec_role where name = 'role_admin'),
        (select id from university_platform.dict_right where name = 'user_delete'));

insert into university_platform.rec_credentials
values (md5(random()::text || clock_timestamp()::text)::uuid, 'admin', 'admin');

insert into university_platform.rec_user
values (md5(random()::text || clock_timestamp()::text)::uuid, 'fAdmin', 'lAdmin',
        (select id from university_platform.rec_role where name = 'role_admin'),
        (select id from university_platform.rec_credentials where login = 'admin'));