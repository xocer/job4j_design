create database treker_db;

create table users(
    id serial primary key,
    name text
);

create table role (
    id serial primary key ,
    name text
);

create table rules (
    id serial primary key ,
    name text
);

create table item (
    id serial primary key ,
    name text
);

create table comments (
    id serial primary key ,
    name text
);

create table attachs (
    id serial primary key ,
    name text
);

create table category (
    id serial primary key ,
    name text
);

create table state (
    id serial primary key ,
    name text
);