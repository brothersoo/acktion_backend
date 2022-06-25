insert into acktion_role(name, created_at, updated_at) values
('ROLE_TEMPORARY_USER', now(), now()),
('ROLE_MEMBER', now(), now()),
('ROLE_ADMIN', now(), now());

insert into acktion_privilege(name, created_at, updated_at) values
('WATCH_AUCTION', now(), now()),
('REQUEST_AUCTION', now(), now()),
('PARTICIPATE_AUCTION', now(), now()),
('MANAGE_AUCTION', now(), now()),
('MANAGE_USER', now(), now()),
('MANAGE_PRODUCT', now(), now());

insert into acktion_role_privilege(created_at, updated_at, acktion_role_id, acktion_privilege_id) values
(now(), now(), 1, 1),
(now(), now(), 2, 1),
(now(), now(), 2, 2),
(now(), now(), 2, 3),
(now(), now(), 3, 4),
(now(), now(), 3, 5),
(now(), now(), 3, 6);
