create table if not exists category (
    uuid varchar(256) primary key,
    title varchar(256),
    hide boolean
)