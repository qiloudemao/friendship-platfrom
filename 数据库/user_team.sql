create table user_team
(
    id         bigint auto_increment comment 'id'
        primary key,
    userId     bigint                             null comment '用户id',
    teamId     bigint                             null comment '队伍id',
    joinTime   datetime                           null comment '加入时间',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0                 not null comment '是否删除'
)
    comment '用户队伍关系';

INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (1, 3, 1, '2024-07-20 15:41:17', '2024-07-20 15:41:16', '2024-07-20 15:41:16', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (2, 3, 2, '2024-07-20 15:43:14', '2024-07-20 15:43:13', '2024-07-20 15:43:13', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (3, 3, 3, '2024-07-20 15:53:35', '2024-07-20 15:53:35', '2024-07-20 15:53:35', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (4, 2, 4, '2024-07-22 19:08:11', '2024-07-22 19:08:11', '2024-07-22 19:08:11', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (5, 2, 2, '2024-07-22 19:47:29', '2024-07-22 19:47:29', '2024-07-24 13:29:04', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (6, 2, 5, '2024-07-22 19:52:50', '2024-07-22 19:52:50', '2024-07-24 13:46:57', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (7, 2, 6, '2024-07-24 00:26:51', '2024-07-24 00:26:50', '2024-07-24 00:26:50', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (8, 2, 7, '2024-07-24 00:26:56', '2024-07-24 00:26:56', '2024-07-24 13:50:12', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (9, 2, 2, '2024-07-24 13:29:14', '2024-07-24 13:29:14', '2024-07-24 13:29:27', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (10, 2, 3, '2024-07-24 13:29:15', '2024-07-24 13:29:15', '2024-07-24 13:40:07', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (11, 2, 2, '2024-07-24 13:48:00', '2024-07-24 13:47:59', '2024-07-24 13:50:09', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (12, 2, 8, '2024-07-24 13:49:21', '2024-07-24 13:49:20', '2024-07-24 13:50:13', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (13, 2, 3, '2024-07-24 13:49:42', '2024-07-24 13:49:42', '2024-07-24 13:50:10', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (14, 2, 2, '2024-07-24 13:50:27', '2024-07-24 13:50:26', '2024-07-25 15:33:37', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (15, 2, 3, '2024-07-24 13:50:28', '2024-07-24 13:50:28', '2024-07-25 14:11:54', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (16, 2, 9, '2024-07-24 13:51:05', '2024-07-24 13:51:05', '2024-07-24 13:51:05', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (17, 2, 10, '2024-07-24 22:54:12', '2024-07-24 22:54:12', '2024-07-24 22:54:12', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (18, 2, 3, '2024-07-25 15:31:21', '2024-07-25 15:31:21', '2024-07-25 15:33:38', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (19, 2, 2, '2024-07-25 15:33:51', '2024-07-25 15:33:51', '2024-07-25 15:33:51', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (20, 2, 3, '2024-07-25 15:37:36', '2024-07-25 15:37:36', '2024-07-25 15:37:36', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (21, 4, 4, '2024-07-25 15:46:42', '2024-07-25 15:46:42', '2024-07-25 16:04:02', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (22, 4, 6, '2024-07-25 15:47:22', '2024-07-25 15:47:22', '2024-07-25 16:06:50', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (23, 4, 2, '2024-07-25 15:47:26', '2024-07-25 15:47:26', '2024-07-25 15:49:20', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (24, 4, 3, '2024-07-25 15:47:27', '2024-07-25 15:47:27', '2024-07-25 15:49:20', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (25, 4, 9, '2024-07-25 15:47:38', '2024-07-25 15:47:37', '2024-07-25 15:47:42', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (26, 4, 2, '2024-07-25 15:50:17', '2024-07-25 15:50:16', '2024-07-25 15:51:34', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (27, 4, 2, '2024-07-25 15:51:42', '2024-07-25 15:51:42', '2024-07-25 15:52:38', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (28, 4, 2, '2024-07-25 15:56:35', '2024-07-25 15:56:43', '2024-07-25 15:59:09', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (29, 4, 3, '2024-07-25 15:59:11', '2024-07-25 15:59:10', '2024-07-25 15:59:10', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (30, 4, 2, '2024-07-25 15:59:18', '2024-07-25 15:59:18', '2024-07-25 15:59:18', 0);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (31, 4, 4, '2024-07-25 16:06:40', '2024-07-25 16:06:40', '2024-07-25 16:06:46', 1);
INSERT INTO friendship.user_team (id, userId, teamId, joinTime, createTime, updateTime, isDelete) VALUES (32, 4, 6, '2024-07-25 16:07:05', '2024-07-25 16:07:04', '2024-07-25 16:07:04', 0);
