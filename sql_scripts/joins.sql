--1
create table departments
(
    id serial primary key,
    name varchar(255)
);

create table emploees
(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values ('Департамент здравоохранения');
insert into departments(name) values ('Департамент полиции');
insert into departments(name) values ('Пожарный департамент');

insert into emploees (name, departments_id) VALUES ('Вася', 1);
insert into emploees (name, departments_id) VALUES ('Сережа', 1);
insert into emploees (name, departments_id) VALUES ('Коля', 2);
insert into emploees (name, departments_id) VALUES ('Илья', 2);
insert into emploees (name, departments_id) VALUES ('Валера', 3);
insert into emploees (name, departments_id) VALUES ('Миша', 3);
insert into emploees (name, departments_id) VALUES ('Максим', null);
insert into emploees (name, departments_id) VALUES ('Олег', null);

--2
select * from emploees left join departments on emploees.departments_id = departments.id;

select * from emploees right join departments on emploees.departments_id = departments.id;
select * from emploees full join departments on emploees.departments_id = departments.id;
select * from emploees cross join departments;

--3
select * from emploees as e left join departments d on e.departments_id = d.id
where e.departments_id is null;

--4
select * from emploees as e left join departments d on e.departments_id = d.id;
select * from departments as d right join emploees e on d.id = e.departments_id;

--5
create table teens
(
    id serial primary key,
    name varchar(255),
    gender char
);

insert into teens (name, gender) VALUES ('Ваня', 'м');
insert into teens (name, gender) VALUES ('Саня', 'м');
insert into teens (name, gender) VALUES ('Даня', 'м');
insert into teens (name, gender) VALUES ('Паша', 'м');
insert into teens (name, gender) VALUES ('Ксюша', 'ж');
insert into teens (name, gender) VALUES ('Анжела', 'ж');
insert into teens (name, gender) VALUES ('Кристина', 'ж');
insert into teens (name, gender) VALUES ('Алина', 'ж');

select * from teens cross join teens t where t.gender <> teens.gender;