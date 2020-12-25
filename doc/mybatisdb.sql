drop table if exists `user`;
create table `user` (
  `id` int(11) not null auto_increment,
  `username` varchar(32) not null comment '用户名称',
  `birthday` datetime default null comment '生日',
  `sex` char(1) default null comment '性别',
  `address` varchar(256) default null comment '地址',
  primary key  (`id`)
) engine=innodb default charset=utf8;

insert  into `user`(`id`,`username`,`birthday`,`sex`,`address`) values (41,'老王','2018-02-27 17:47:08','男','北京'),(42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),(43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),(45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),(46,'老王','2018-03-07 17:37:26','男','北京'),(48,'小马宝莉','2018-03-08 11:44:00','女','北京修正');

drop table if exists `account`;
create table `account` (
  `id` int(11) not null comment '编号',
  `uid` int(11) default null comment '用户编号',
  `money` double default null comment '金额',
  primary key  (`id`),
  key `fk_reference_8` (`uid`),
  constraint `fk_reference_8` foreign key (`uid`) references `user` (`id`)
) engine=innodb default charset=utf8;

insert  into `account`(`id`,`uid`,`money`) values (1,46,1000),(2,45,1000),(3,46,2000);

drop table if exists `role`;
create table `role` (
  `id` int(11) not null comment '编号',
  `role_name` varchar(30) default null comment '角色名称',
  `role_desc` varchar(60) default null comment '角色描述',
  primary key  (`id`)
) engine=innodb default charset=utf8;

insert  into `role`(`id`,`role_name`,`role_desc`) values (1,'院长','管理整个学院'),(2,'总裁','管理整个公司'),(3,'校长','管理整个学校');

drop table if exists `user_role`;
create table `user_role` (
  `uid` int(11) not null comment '用户编号',
  `rid` int(11) not null comment '角色编号',
  primary key  (`uid`,`rid`),
  key `fk_reference_10` (`rid`),
  constraint `fk_reference_10` foreign key (`rid`) references `role` (`id`),
  constraint `fk_reference_9` foreign key (`uid`) references `user` (`id`)
) engine=innodb default charset=utf8;

insert  into `user_role`(`uid`,`rid`) values (41,1),(45,1),(41,2);


