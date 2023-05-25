insert into carts(user_id)
values (1),
       (2);



insert into orders(address, date, post_index, total_sum, user_id)
values ('manasa 68', '2023-05-04 16:43:32.000000', '720060', 200, 1),
       ('10th microdistrict 40', '2023-05-04 16:43:32.000000', '588002', 100, 2);



create table ordered_items
(
    id       bigserial not null,
    order_id bigint,
    item_id  bigint,
    primary key (id)
);

alter table if exists ordered_items add constraint order_id foreign key (order_id) references orders;
alter table if exists ordered_items add constraint item_id foreign key (item_id) references items;



insert into ordered_items(order_id, item_id)
values (1, 1);
