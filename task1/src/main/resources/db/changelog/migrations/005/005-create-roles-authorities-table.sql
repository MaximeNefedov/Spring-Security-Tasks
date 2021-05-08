create table roles_authorities
(
    role_id int check ( role_id > 0 )       not null,
    authority_id int check ( authority_id > 0 ) not null,
    primary key (role_id, authority_id),
    foreign key (role_id) references roles (id),
    foreign key (authority_id) references authorities (id)
)