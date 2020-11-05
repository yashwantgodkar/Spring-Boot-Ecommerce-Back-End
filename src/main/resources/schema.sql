drop table if exists topics;
drop table if exists users;

create table product (
        product_id integer not null auto_increment,
        product_name varchar(100) not null,
        product_desc varchar(100) not null,
        primary key (product_id)
    );
    
     create table users (
        username varchar(50) not null,
        password varchar(800) not null,
        role varchar(50),
        primary key (username)
    );
  