create database machine_storage;

create table car_body
(
    id serial primary key,
    name varchar(255)
);

create table engine
(
    id serial primary key,
    name varchar(255)
);

create table transmission
(
    id serial primary key,
    name varchar(255)
);

create table car
(
    id serial primary key,
    name varchar(255),
    car_body_id int references car_body(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

insert into car_body (name)
values ('Седан'), ('Хетчбэк'), ('Пикап');

insert into transmission (name)
values ('Ручная'), ('Автоматическая'), ('Дсг');

insert into engine (name)
values ('Бензиновый'), ('Дизельный'), ('Гибрид');

insert into car (name, car_body_id, engine_id, transmission_id)
values ('Митсубиси Лансер', 1, 1, 1), ('Порш Каен', 2, 2, 2);

select c.name as Марка, cb.name as Кузов, e.name as Двигатель, t.name as Коробка
from car as c
    join car_body cb on c.car_body_id = cb.id
    join engine e on c.engine_id = e.id
    join transmission t on c.transmission_id = t.id
group by c.name, cb.name, e.name, t.name;