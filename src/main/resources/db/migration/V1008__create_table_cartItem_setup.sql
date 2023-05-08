create table cart_items
(
    id       bigserial not null,
    cart_id  bigint,
    item_id  bigint,
    quantity bigint,
    primary key (id)
);


alter table if exists cart_items add constraint cart_id foreign key (cart_id) references carts;


insert into reviews(text, user_id, date, item_id)
values ('good', 1, '2023-05-04 16:43:32.000000', 2),
       ('bad', 1, '2023-05-04 16:43:32.000000', 1),
       ('ok', 2, '2023-05-04 16:43:32.000000', 1),
       ('good', 2, '2023-05-04 16:43:32.000000', 2);


insert into cart_items(cart_id, item_id, quantity)
values (1, 1, 2),
       (2, 2, 2),
       (3, 3, 3),
       (1, 1, 1);