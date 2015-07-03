insert into `role` values (1, 'admin');
insert into `role` values (2, 'guest');

insert into `user` (username, password, active, role_id) values ('bin', 'bin', true, 1);
insert into `user` (username, password, active, role_id) values ('bon', 'bon', true, 1);
insert into `user` (username, password, active, role_id) values ('bun', 'bun', true, 1);
insert into `user` (username, password, active, role_id) values ('binh', 'binh', true, 2);
insert into `user` (username, password, active, role_id) values ('binh2', 'binh2', true, 2);
insert into `user` (username, password, active, role_id) values ('binh3', 'binh3', true, 2);
insert into `user` (username, password, active, role_id) values ('binh4', 'binh5', true, 2);
insert into `user` (username, password, active, role_id) values ('binh6', 'binh6', false, 2);
insert into `user` (username, password, active, role_id) values ('binh7', 'binh7', false, 2);