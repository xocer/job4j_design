create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);

create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);

insert into devices(name, price) VALUES ('iPhone', 25000);
insert into devices(name, price) VALUES ('watch', 7000);
insert into devices(name, price) VALUES ('airPods', 12000);
insert into devices(name, price) VALUES ('Чехол', 500);

insert into people(name) values ('Вася');
insert into people(name) values ('Андрей');
insert into people(name) values ('Антон');
insert into people(name) values ('Игнат');

insert into devices_people (device_id, people_id) VALUES (1,1);
insert into devices_people (device_id, people_id) VALUES (2,1);
insert into devices_people (device_id, people_id) VALUES (3,1);
insert into devices_people (device_id, people_id) VALUES (1,2);
insert into devices_people (device_id, people_id) VALUES (1,3);
insert into devices_people (device_id, people_id) VALUES (3,3);
insert into devices_people (device_id, people_id) VALUES (1,4);
insert into devices_people (device_id, people_id) VALUES (2,4);
insert into devices_people (device_id, people_id) VALUES (4, 4);

select avg(price) from devices;

select p.name, avg(d.price) from people as p join devices_people dp on p.id = dp.people_id join devices d on d.id = dp.device_id
group by p.name;

select p.name, avg(d.price) from people as p join devices_people dp on p.id = dp.people_id join devices d on d.id = dp.device_id
where d.price > 5000
group by p.name;