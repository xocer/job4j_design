create database cars;
create table cars (
    id serial primary key,
    class varchar,
    weight int,
    yearOfIssue date
);
insert into cars (class, weight, yearOfIssue) VALUES ('S-class', 2000, '2019-02-01');
insert into cars (class, weight, yearOfIssue) VALUES ('C-class', 1750, '2015-04-05');
update cars set class = 'B-class';
delete from cars;

select * from cars;