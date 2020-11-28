create database treker_db;

create table users(
    id serial primary key,
    name text,
    role_id int REFERENCES role(id)
);

create table role (
    id serial primary key ,
    name text
);

create table rules (
    id serial primary key ,
    name text
);

create table role_rules (
    id SERIAL PRIMARY KEY ,
    role_id int REFERENCES role(id),
    rules_id int REFERENCES rules(id)
);

create table item (
    id serial primary key ,
    name text ,
    user_id int REFERENCES users(id),
    category_id int REFERENCES category(id),
    state_id int REFERENCES state(id)
);

create table comments (
    id serial primary key ,
    name text ,
    item_id int REFERENCES item(id)
);

create table attachs (
    id serial primary key ,
    name text,
    item_id int REFERENCES item(id)
);

create table category (
    id serial primary key ,
    name text
);

create table state (
    id serial primary key ,
    name text
);