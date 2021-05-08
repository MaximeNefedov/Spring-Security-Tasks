insert into users (username, password)
VALUES ('Max', crypt('12345', gen_salt('bf', 12)));

insert into users (username, password)
VALUES ('Neil', crypt('123', gen_salt('bf', 12)));