create table if not exists category (
    uuid varchar(256) primary key,
    title varchar(256),
    hide boolean
);
create index if not exists category_name_index on category(title)