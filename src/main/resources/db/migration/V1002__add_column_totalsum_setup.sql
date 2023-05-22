create table carts
(
    id      bigserial not null,
    user_id bigint,
    primary key (id)
);

create table orders
(
    id         bigserial not null,
    address    varchar(128),
    date       timestamp without time zone NOT NULL,
    post_index bigint,
    total_sum  bigint,
    cart_id    bigint,
    primary key (id)
);

alter table if exists carts add constraint FKn4foj467c1dwfb0caomaqkv5l foreign key (user_id) references usr;

alter table if exists orders add constraint cart_id foreign key (cart_id) references carts;
-- alter table if exists orders add constraint FK7ncuqw9n77odylknbo8aikc9w foreign key (user_id) references usr;


