create table users
(
    username varchar(50)  not null primary key,
    password varchar(256) not null,
    enabled  boolean      not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);
create unique index ix_auth_username on authorities (username, authority);

create table system_permissions
(
    id             bigint auto_increment primary key,
    username       varchar(128)         not null,
    permission_tag varchar(128)         not null,
    has_permission tinyint(1) default 1 not null
);
