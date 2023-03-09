CREATE TABLE `user`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `real_name`      varchar(255) DEFAULT NULL COMMENT '真实名',
    `user_name`      varchar(100) DEFAULT NULL COMMENT '用户名',
    `password`       varchar(255) DEFAULT NULL COMMENT '密码',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `modify_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `fk_create_user` int          DEFAULT NULL COMMENT '创建人',
    `fk_modify_user` int          DEFAULT NULL COMMENT '更新人',
    `is_valid`       int          DEFAULT NULL COMMENT '1.有效 0.无效',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `basetable`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `create_time`    datetime DEFAULT NULL COMMENT '创建时间',
    `modify_time`    datetime DEFAULT NULL COMMENT '更新时间',
    `fk_create_user` int      DEFAULT NULL COMMENT '创建人',
    `fk_modify_user` int      DEFAULT NULL COMMENT '更新人',
    `is_valid`       int      DEFAULT NULL COMMENT '1.有效 0.无效',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;