INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$MwVyKkeVBkIIOBw8vSZMRew5JBm1FFOlvUdjtQvo/ulu3e2u/yKFS', 1);
INSERT INTO users (username, password, enabled) VALUES ('henge', '$2a$10$B877TJYFJa6oiQ9JynVny.94Ekwk5bCFD7vD8wHiaPw/ErmgG5xPS', 1);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_admin');
INSERT INTO authorities (username, authority) VALUES ('henge', 'ROLE_user');

INSERT INTO system_permissions (id, username, permission_tag, has_permission) VALUES (2, 'admin', 'home_admin', 1);
INSERT INTO system_permissions (id, username, permission_tag, has_permission) VALUES (3, 'admin', 'home_misc', 1);
INSERT INTO system_permissions (id, username, permission_tag, has_permission) VALUES (4, 'henge', 'home_admin', 0);
INSERT INTO system_permissions (id, username, permission_tag, has_permission) VALUES (5, 'henge', 'home_misc', 1);

INSERT INTO author (id, last_name, first_name, username, email) VALUES (1, 'tom', 'sanders', 'tsanders', 'tsanders@gmail.com');

INSERT INTO post (id, version, title, content, published_on, updated_on, author) VALUES (1, null, 'post01', 'content01', '2023-11-28 22:16:28', null, 1);
INSERT INTO post (id, version, title, content, published_on, updated_on, author) VALUES (2, null, 'post02', 'content02', '2023-11-28 22:16:56', null, 1);

INSERT INTO comment (id, post, name, content, published_on, updated_on) VALUES (1, 1, 'c1', 'content01', '2023-11-28 22:17:38', null);
INSERT INTO comment (id, post, name, content, published_on, updated_on) VALUES (2, 1, 'c2', 'content02', '2023-11-28 22:17:55', null);
INSERT INTO comment (id, post, name, content, published_on, updated_on) VALUES (3, 2, 'c3', 'content03', '2023-11-28 22:18:24', null);
INSERT INTO comment (id, post, name, content, published_on, updated_on) VALUES (4, 2, 'c4', 'content04', '2023-11-28 22:18:21', null);
