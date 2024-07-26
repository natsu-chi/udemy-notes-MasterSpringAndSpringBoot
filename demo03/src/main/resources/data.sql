insert into user_details (user_id, name, birth_date) values (1001, 'usera', '2001-10-01');
insert into user_details (user_id, name, birth_date) values (1002, 'userb', '1990-12-31');

insert into word (id, word, meaning, user_id) values (1, 'template', 'a pattern made of metal, plastic, or paper, used for making many copies of a shape or to help cut material accurately.', 1001);
insert into word (id, word, meaning, user_id) values (2, 'coffee badging', 'the activity of going to your place of work and staying just long enough to have a coffee with colleagues before going home again to work there', 1002);

-- 資料表 id 插入順序配置
alter table user_details alter column user_id restart with 1003;
alter table word alter column id restart with 3;