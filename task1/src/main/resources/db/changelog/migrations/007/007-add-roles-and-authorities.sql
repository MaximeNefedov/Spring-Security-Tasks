insert into roles (name) values ('ADMIN');
insert into roles (name) values ('USER');

insert into authorities (name) values ('READ');
insert into authorities (name) values ('WRITE');

insert into roles_authorities (role_id, authority_id) values (1, 1);
insert into roles_authorities (role_id, authority_id) values (1, 2);
insert into roles_authorities (role_id, authority_id) values (2, 1);

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);