create table type
(
    id serial primary key ,
    name varchar(255)
);

create table product
(
    id serial primary key ,
    name varchar (255),
    type_id int references type(id),
    expired_date date,
    price float
);

insert into type (name) values ('сыр');
insert into type (name) values ('молоко');
insert into type (name) values ('яица');
insert into type (name) values ('хлеб');
insert into type (name) values ('сладкое');

insert into product (name, type_id, expired_date, price) VALUES ('Вологодский пармезан', 1, '2020.12.29', 300);
insert into product (name, type_id, expired_date, price) VALUES ('Домик в деревне', 2, '2020.12.05', 70);
insert into product (name, type_id, expired_date, price) VALUES ('Радужное мороженное', 5, '2021.01.10', 230);
insert into product (name, type_id, expired_date, price) VALUES ('Простоквашино', 2, '2022.12.29', 65);
insert into product (name, type_id, expired_date, price) VALUES ('Утинные яйца', 3, '2021.10.22', 600);
insert into product (name, type_id, expired_date, price) VALUES ('мороженное без сахара', 5, '2021.03.14', 270);
insert into product (name, type_id, expired_date, price) VALUES ('Маасдам', 1, '2025.06.03', 550);

--1
select * from product as p join type t on p.type_id = t.id
where t.name = 'сыр';
--2
select * from product where name like '%мороженное%';
--3
select * from product where expired_date = current_date + interval '1 month';
--4
select name, price from product where price = (select max(price) from product);
--5
select type.name, count(type.name) from type join product p on type.id = p.type_id group by type.name;
--6
select * from product join type t on product.type_id = t.id where t.name = 'сыр' or t.name = 'молоко';
--7
select t.name from type as t join product p on t.id = p.type_id group by t.name having count(t.name) < 10;
--8
select p.name as Название, t.name as Тип from product as p join type t on p.type_id = t.id group by t.name, p.name;