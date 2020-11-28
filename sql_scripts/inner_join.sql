create table city
(
    id   serial primary key,
    name varchar(255)
);

create table districts
(
    id      serial primary key,
    name    varchar(255),
    city_id int references city (id)
);

insert into city (name) values ('Saint_Peterburg');
insert into city (name) values ('Moscow');
insert into districts (name, city_id) values ('Красногвардейский', 1);
insert into districts (name, city_id) values ('Калининский', 1);
insert into districts (name, city_id) values ('Ленинский', 2);
insert into districts (name, city_id) values ('Сталинский', 2);
insert into districts (name, city_id) values ('Путинский', 2);

select * from city c join districts d on c.id = d.city_id;
select c.name, d.name from city as c join districts d on c.id = d.city_id;
select c.name as Город, d.name as Район from city as c join districts d on c.id = d.city_id;