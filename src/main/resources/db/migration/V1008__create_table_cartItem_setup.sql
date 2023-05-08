create table cart_items
(
    id       bigserial not null,
    cart_id  bigint,
    item_id  bigint,
    quantity bigint,
    primary key (id)
);


alter table if exists cart_items add constraint cart_id foreign key (cart_id) references carts;


