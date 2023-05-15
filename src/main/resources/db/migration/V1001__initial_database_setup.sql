create table items
(
    id          bigserial not null,
    name        varchar(128),
    category_id    bigint,
    image       varchar(128),
    description varchar(128),
    size        varchar(128),
    color       varchar(128),
    price       bigint,
    amount      bigint,
    primary key (id)
);


create table categories
(
    id   bigserial not null,
    name varchar(128),
    primary key (id)
);

alter table if exists items add constraint category_id foreign key (category_id) references categories;


insert into categories(name)
values ('clothes'),
       ('shoes'),
       ('bags');

create table usr
(
    id           bigserial not null,
    name         varchar(128),
    account_name varchar(128),
    email        varchar(128),
    password     varchar(128),
    primary key (id)
);
