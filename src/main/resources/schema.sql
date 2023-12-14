create table if not exists users
(
    username varchar(50)  not null primary key,
    password varchar(256) not null,
    enabled  boolean      not null
);

create table if not exists authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username, authority);

create table if not exists system_permissions
(
    id             bigint auto_increment primary key,
    username       varchar(128) not null,
    permission_tag varchar(128) not null,
    has_permission tinyint(1) default 1 not null
);

create table if not exists author
(
    id         int auto_increment primary key,
    last_name  varchar(80)  not null,
    first_name varchar(255) not null,
    username   varchar(100) not null,
    email      varchar(127) not null
);

create table if not exists post
(
    id           bigint auto_increment primary key,
    version      int,
    title        varchar(255) not null,
    content      text         not null,
    published_on timestamp    not null,
    updated_on   timestamp,
    author       int,
    foreign key (author) references author (id)
);

create table if not exists comment
(
    id          int auto_increment primary key,
    post         bigint       not null,
    name         varchar(127) not null,
    content      text         not null,
    published_on timestamp    not null,
    updated_on   timestamp,

    foreign key (post) references post (id)
);

