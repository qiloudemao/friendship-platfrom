create table team
(
    id          bigint auto_increment comment 'id'
        primary key,
    name        varchar(256)                       not null comment '队伍名称',
    description varchar(1024)                      null comment '描述',
    maxNum      int      default 1                 not null comment '最大人数',
    expireTime  datetime                           null comment '过期时间',
    userId      bigint                             null comment '用户id（队长 id）',
    status      int      default 0                 not null comment '0 - 公开，1 - 私有，2 - 加密',
    password    varchar(512)                       null comment '密码',
    createTime  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete    tinyint  default 0                 not null comment '是否删除'
)
    comment '队伍';

INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (1, 'wtc测试更新', '测试更新', 5, '2024-12-30 08:00:00', 3, 1, '1234567', '2024-07-20 15:41:16', '2024-07-22 00:12:15', 0);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (2, 'wt小队', '测试小队', 5, '2024-10-10 08:00:00', 3, 0, '', '2024-07-20 15:43:13', '2024-07-20 15:43:13', 0);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (3, 'wt小队', '测试小队', 5, '2024-10-10 08:00:00', 3, 0, '', '2024-07-20 15:53:35', '2024-07-20 15:53:35', 0);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (4, '前端测试添加', 'dasdasdkas撒大苏打实打实的卡撒大苏打ask大数据的卡上打赏阿萨大数据的卡仕达达到wda', 4, '2024-07-26 00:00:00', 2, 2, '12345678', '2024-07-22 19:08:11', '2024-07-22 19:08:11', 0);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (5, '前端测试小队1', '大苏打十大挖的阿萨的委', 6, '2024-12-23 00:00:00', 2, 0, '', '2024-07-22 19:52:50', '2024-07-24 13:46:57', 1);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (6, '前端测试小队1', '大苏打十大挖的阿萨的委屈委屈我去恶趣味请问请问请问', 6, '2024-12-15 00:00:00', 2, 2, '123456', '2024-07-24 00:26:50', '2024-07-24 00:26:50', 0);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (7, '前端测试小队2', '大苏打十大挖的阿萨的委屈委屈我去恶趣味请问请问请问', 6, '2024-12-15 00:00:00', 2, 0, '', '2024-07-24 00:26:56', '2024-07-24 13:50:12', 1);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (8, '前端测试d 阿萨的', '的撒旦阿萨的asd大三大十大撒旦阿萨的', 12, '2024-12-31 00:00:00', 2, 0, '', '2024-07-24 13:49:20', '2024-07-24 13:50:13', 1);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (9, '前端测试123', '十大十大十大实打实dasd的', 14, '2024-12-01 08:00:00', 2, 0, '', '2024-07-24 13:51:05', '2024-07-24 13:51:05', 0);
INSERT INTO friendship.team (id, name, description, maxNum, expireTime, userId, status, password, createTime, updateTime, isDelete) VALUES (10, '前端测试123', '是根据客户看海关监管交换机和更高的好几个那么根据客户跟进和计划 ', 20, '2024-12-31 00:00:00', 2, 0, '', '2024-07-24 22:54:12', '2024-07-24 22:54:12', 0);
