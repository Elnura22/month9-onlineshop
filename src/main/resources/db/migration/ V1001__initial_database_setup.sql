use
`postgres`;

Hibernate
:
create table items
(
    id          bigint not null,
    amount      bigint,
    category    varchar(128),
    description varchar(128),
    image       varchar(128),
    name        varchar(128),
    price       bigint,
    primary key (id)
) Hibernate:
create table orders
(
    id         bigint not null,
    address    varchar(128),
    date       timestamp(6),
    post_index varchar(128),
    item_id    bigint,
    user_id    bigint,
    primary key (id)
) Hibernate:
create table usr
(
    id           bigint not null,
    account_name varchar(128),
    email        varchar(128),
    password     varchar(128),
    primary key (id)
) Hibernate:
alter table if exists orders add constraint FK247nnxschdfm8lre0ssvy3k1r foreign key (item_id) references items
    Hibernate:
alter table if exists orders add constraint FK7ncuqw9n77odylknbo8aikc9w foreign key (user_id) references usr


