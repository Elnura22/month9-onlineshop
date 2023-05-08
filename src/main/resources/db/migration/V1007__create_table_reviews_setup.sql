create table reviews
(
    id      bigserial not null,
    text    varchar(128),
    user_id bigint,
    date    timestamp without time zone NOT NULL,
    item_id bigint,
        primary key (id)
);

alter table if exists reviews add constraint user_id foreign key (user_id) references usr;
