create table user
(
    username     varchar(256)                       null comment '用户昵称',
    id           bigint auto_increment comment 'id'
        primary key,
    userAccount  varchar(256)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '用户头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(512)                       not null comment '密码',
    phone        varchar(128)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '状态 0 - 正常',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    planetCode   varchar(512)                       null comment '星球编号',
    tags         varchar(1024)                      null comment '标签 json 列表',
    profile      varchar(512)                       null
)
    comment '用户';

INSERT INTO friendship.user (username, id, userAccount, avatarUrl, gender, userPassword, phone, email, userStatus, createTime, updateTime, isDelete, userRole, planetCode, tags, profile) VALUES ('wt', 1, 'wwwt', 'http://www.w3.org/2000/svg', 1, 'a982df58eaa5b4026d0c20ff38c9a893', '231231', '3213123', 0, '2024-07-04 17:02:12', '2024-07-10 20:47:15', 0, 1, '1', '["java","c++","python","男"]', '阿爸啊实打实');
INSERT INTO friendship.user (username, id, userAccount, avatarUrl, gender, userPassword, phone, email, userStatus, createTime, updateTime, isDelete, userRole, planetCode, tags, profile) VALUES ('wt10', 2, 'wwt1', '2', 1, 'a982df58eaa5b4026d0c20ff38c9a893', '17808543879', '231231231@qq.com', 1, '2024-07-09 17:42:37', '2024-07-22 19:51:52', 0, 1, '2', '["java","c++","python","女"]', '撒大苏打');
INSERT INTO friendship.user (username, id, userAccount, avatarUrl, gender, userPassword, phone, email, userStatus, createTime, updateTime, isDelete, userRole, planetCode, tags, profile) VALUES ('w2', 3, 'www2', '3', 1, 'a982df58eaa5b4026d0c20ff38c9a893', '1321312', '32131231231', 0, '2024-07-09 17:42:37', '2024-07-10 20:47:16', 0, 1, '3', '["java","c++","python","男"]', '啊八八八');
INSERT INTO friendship.user (username, id, userAccount, avatarUrl, gender, userPassword, phone, email, userStatus, createTime, updateTime, isDelete, userRole, planetCode, tags, profile) VALUES ('wt3', 4, 'wwt3', '4', 0, 'a982df58eaa5b4026d0c20ff38c9a893', '231231', '3213123', 0, '2024-07-04 17:02:12', '2024-07-10 20:47:15', 0, 1, '4', '["java","c++","python","女"]', '阿爸啊实打实');
INSERT INTO friendship.user (username, id, userAccount, avatarUrl, gender, userPassword, phone, email, userStatus, createTime, updateTime, isDelete, userRole, planetCode, tags, profile) VALUES ('wt4', 5, 'wwt4', '5', 1, 'a982df58eaa5b4026d0c20ff38c9a893', '231231', '3213123', 0, '2024-07-04 17:02:12', '2024-07-10 20:47:16', 0, 1, '5', '["java","c++","python","男"]', '阿爸啊实打实');
INSERT INTO friendship.user (username, id, userAccount, avatarUrl, gender, userPassword, phone, email, userStatus, createTime, updateTime, isDelete, userRole, planetCode, tags, profile) VALUES ('wt6', 6, 'wwtt6', 'null', null, 'a982df58eaa5b4026d0c20ff38c9a893', null, null, 0, '2024-07-10 14:20:53', '2024-07-19 12:58:25', 0, 0, '8', '["java","c++","python","女"]', null);
