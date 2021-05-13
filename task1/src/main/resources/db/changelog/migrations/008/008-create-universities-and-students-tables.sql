create table universities
(
    id   serial primary key,
    name varchar(255) unique not null
);

insert into universities (name)
values ('GUAP');
insert into universities (name)
values ('MSU');
insert into universities (name)
values ('SPBSTU');

create table students
(
    id            serial primary key ,
    name          varchar(255) not null,
    surname       varchar(255) not null,
    university_id int references universities (id)
);

insert into students (name, surname, university_id)
values ('Max', 'Nefedov', 1);
insert into students (name, surname, university_id)
values ('Neil', 'Brown', 1);
insert into students (name, surname, university_id)
values ('John', 'Smith', 3);
insert into students (name, surname, university_id)
values ('Dmitry', 'Vaganov', 1);
insert into students (name, surname, university_id)
values ('Ivan', 'Ivanov', 1);
insert into students (name, surname, university_id)
values ('Anton', 'Petrov', 3);
insert into students (name, surname, university_id)
values ('John', 'Doe', 3);
insert into students (name, surname, university_id)
values ('John', 'Connor', 2);
insert into students (name, surname, university_id)
values ('Anna', 'Smirnova', 2);
insert into students (name, surname, university_id)
values ('Kate', 'Garcia', 2);
insert into students (name, surname, university_id)
values ('Maxim', 'Ivanov', 1);
insert into students (name, surname, university_id)
values ('Atrem', 'Cherednikov', 3);
insert into students (name, surname, university_id)
values ('Emil', 'Adilov', 2);
insert into students (name, surname, university_id)
values ('Dmitry', 'Reygelman', 1);
insert into students (name, surname, university_id)
values ('Mike', 'Lawrey', 3);