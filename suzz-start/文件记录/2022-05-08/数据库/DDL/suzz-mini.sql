CREATE TABLE `province`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;



CREATE TABLE `province_lang`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_province`    int          DEFAULT NULL COMMENT '省份id',
    `name`           varchar(255) DEFAULT NULL COMMENT '省份名称',
    `lang`           varchar(255) DEFAULT NULL COMMENT '语言',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `city`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `code`           int        DEFAULT NULL COMMENT '编码',
    `fk_province`    int        DEFAULT NULL COMMENT '省份id',

    PRIMARY KEY (`id`)
) ENGINE = InnoDB;


CREATE TABLE `city_lang`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_city`        int          DEFAULT NULL COMMENT '城市id',
    `name`           varchar(255) DEFAULT NULL COMMENT '城市名称',
    `lang`           varchar(255) DEFAULT NULL COMMENT '语言',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `area`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_city`        int          DEFAULT NULL COMMENT '城市id',
    `code`           varchar(255) DEFAULT NULL COMMENT '区域code',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `area_lang`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_area`        int          DEFAULT NULL COMMENT '区域id',
    `name`           varchar(255) DEFAULT NULL COMMENT '名称',
    `lang`           varchar(255) DEFAULT NULL COMMENT '语言',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `mini_user`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `sex`            tinyint(1)                                               DEFAULT NULL COMMENT '0.男 1.女',
    `type`           int                                                      DEFAULT NULL COMMENT '1.司机 2货主',
    `user_name`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  DEFAULT NULL COMMENT '用户名称',
    `phone`          varchar(255)                                             DEFAULT NULL COMMENT '手机号',
    `open_id`        varchar(255)  DEFAULT NULL COMMENT 'openId',
    `union_id`       varchar(255)  DEFAULT NULL COMMENT 'unionId',
    `language`       varchar(255)                                             DEFAULT NULL COMMENT '语言',
    `introduce`      varchar(1000) DEFAULT NULL COMMENT '个人介绍',
    `head_pic`       varchar(2000)                                            DEFAULT NULL COMMENT '头像',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `page`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `name`           varchar(255) DEFAULT NULL COMMENT '页面名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `page_module`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_page`        int          DEFAULT NULL COMMENT '页面id',
    `code`           varchar(255) DEFAULT NULL COMMENT 'code',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `page_module_lang`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_page_module` int                                                     DEFAULT NULL COMMENT '页面模块id',
    `name`           varchar(255) DEFAULT NULL COMMENT '操作名称',
    `lang`           varchar(255)                                            DEFAULT NULL COMMENT '语言',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `order`
(
    `id`                  int NOT NULL AUTO_INCREMENT,
    `fk_mini_user`        int                                                      DEFAULT NULL COMMENT '用户id',
    `status`              int                                                      DEFAULT NULL COMMENT '1.审核中 2.已上架 3.已下架 4.审核拒绝',
    `departure_area_code` varchar(255) DEFAULT NULL COMMENT '出发区域code 6位数 2位省份2位城市 2位区域',
    `arrive_area_code`    varchar(255)                                             DEFAULT NULL COMMENT '目的区域code 6位数 2位省份2位城市 2位区域',
    `use_start_date`      date                                                     DEFAULT NULL COMMENT '使用开始时间',
    `min_ton`             int                                                      DEFAULT NULL COMMENT '最小吨位',
    `max_ton`             int                                                      DEFAULT NULL COMMENT '最大吨位',
    `price_style`         int                                                      DEFAULT NULL COMMENT '价格方式 1.价格 2.电议',
    `price`               decimal(10, 2)                                           DEFAULT NULL COMMENT '价格',
    `goods_info`          varchar(8000) DEFAULT NULL COMMENT '货源信息',
    `create_time`         datetime                                                 DEFAULT NULL COMMENT '创建时间',
    `modify_time`         datetime                                                 DEFAULT NULL COMMENT '更新时间',
    `is_valid`            tinyint(1)                                               DEFAULT NULL COMMENT '1.有效 0.无效',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `order_car_type`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_order`       int        DEFAULT NULL COMMENT '订单id',
    `car_type`       int        DEFAULT NULL COMMENT '用车类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `dictionary`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `code`           varchar(255) DEFAULT NULL COMMENT 'code',
    `key`            int          DEFAULT NULL COMMENT 'key',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='字典表';

CREATE TABLE `dictionary_lang`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_dictionary`  int          DEFAULT NULL,
    `name`           varchar(255) DEFAULT NULL COMMENT '值',
    `lang`           varchar(255) DEFAULT NULL COMMENT '语言',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='字典语言表';

CREATE TABLE `exception`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `code`           varchar(255) DEFAULT NULL COMMENT '异常code',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='异常信息';

CREATE TABLE `exception_lang`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `fk_exception`   int           DEFAULT NULL COMMENT '异常主键id',
    `lang`           varchar(255)  DEFAULT NULL COMMENT '语言',
    `name`           varchar(2000) DEFAULT NULL COMMENT '异常信息',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `order_audit`
(
    `id`              int NOT NULL AUTO_INCREMENT,
    `fk_order`      int           DEFAULT NULL COMMENT '订单id',
    `fk_audit_user`   int           DEFAULT NULL COMMENT '审批人',
    `audit_user_name` varchar(255)  DEFAULT NULL COMMENT '审批姓名',
    `status`          int           DEFAULT NULL COMMENT '1.审核通过 2.审核拒绝',
    `reject_remark`   varchar(1024) DEFAULT NULL COMMENT '审批拒绝理由',
    `audit_content`   json          DEFAULT NULL COMMENT '审核内容',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

ALTER TABLE `suzz-mini`.`province_lang`
    ADD INDEX `idx_fk_province_lang` (`fk_province`, `lang`) USING BTREE;

ALTER TABLE `suzz-mini`.`city`
    ADD INDEX `idx_fk_province` (`fk_province`) USING BTREE;

ALTER TABLE `suzz-mini`.`area`
    ADD INDEX `idx_fk_city` (`fk_city`) USING BTREE;

ALTER TABLE `suzz-mini`.`area_lang`
    ADD INDEX `idx_fk_area_lang` (`fk_area`, `lang`) USING BTREE;

ALTER TABLE `suzz-mini`.`city_lang`
    ADD INDEX `idx_fk_city_lang`(`fk_city`, `lang`) USING BTREE;

ALTER TABLE `suzz-mini`.`dictionary_lang`
    ADD INDEX `idx_dictionary_lang`(`fk_dictionary`, `lang`) USING BTREE;

ALTER TABLE `suzz-mini`.`order`
    ADD COLUMN `language` varchar(255) COMMENT '派发任务使用的语言' AFTER `use_start_date`;

ALTER TABLE `suzz-mini`.`order`
    ADD COLUMN `publish_time` datetime(0) DEFAULT NULL COMMENT '发布时间' AFTER `goods_info`;

CREATE TABLE `suzz-mini`.`order_look` (
      `id` int NOT NULL AUTO_INCREMENT,
      `fk_order` int DEFAULT NULL COMMENT '发布id',
      `fk_mini_user` int DEFAULT NULL COMMENT '查看用户',
      `num` int DEFAULT NULL COMMENT '查看次数',
      `look_time` date DEFAULT NULL COMMENT '查看日期',
      `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
      PRIMARY KEY (`id`),
      KEY `idx_fk_order` (`fk_order`) USING BTREE
) ENGINE=InnoDB COMMENT='发布查阅信息';


CREATE TABLE `suzz-mini`.`mini_user_focus` (
     `id` int NOT NULL AUTO_INCREMENT,
     `fk_mini_user` int DEFAULT NULL COMMENT '被关注用户',
     `fk_mini_user_focus` int DEFAULT NULL COMMENT '关注用户',
     `is_valid` tinyint(1) DEFAULT NULL COMMENT '1.有效 0.无效',
     PRIMARY KEY (`id`),
     KEY `index_fk_mini_user` (`fk_mini_user`) USING BTREE,
     KEY `index_fk_mini_user_focus` (`fk_mini_user_focus`) USING BTREE
) ENGINE=InnoDB COMMENT='关注表';

CREATE TABLE `suzz-mini`.`order_collection` (
      `id` int NOT NULL AUTO_INCREMENT,
      `fk_order` int DEFAULT NULL COMMENT '发布id',
      `fk_mini_user` int DEFAULT NULL COMMENT '收藏的用户id',
      `is_valid` tinyint(1) DEFAULT NULL COMMENT '1.有效 0.无效',
      PRIMARY KEY (`id`),
      KEY `index_fk_order` (`fk_order`) USING BTREE,
      KEY `index_fk_mini_user` (`fk_mini_user`) USING BTREE
) ENGINE=InnoDB COMMENT='收藏表';

ALTER TABLE `suzz-mini`.`order_look`
    ADD INDEX `idx_fk_mini_user`(`fk_mini_user`) USING BTREE;

CREATE TABLE `suzz-mini`.`suggest` (
       `id` int NOT NULL AUTO_INCREMENT,
       `type` int DEFAULT NULL COMMENT '1.服务投诉 2.功能异常 3.新功能建议 4.违规举报',
       `fk_mini_user` int DEFAULT NULL COMMENT '被投诉用户',
       `fk_mini_user_suggest` int DEFAULT NULL COMMENT '投诉用户',
       `fk_order` int DEFAULT NULL COMMENT '被投诉发布id',
       `status` int DEFAULT NULL COMMENT '1.处理中 2.已处理 3.已取消',
       `content` text COMMENT '内容',
       `contact_name` varchar(255) DEFAULT NULL COMMENT '联系人名称',
       `contact_phone` varchar(255) DEFAULT NULL COMMENT '联系人手机号',
       PRIMARY KEY (`id`),
       KEY `idx_fk_mini_user_suggest` (`fk_mini_user_suggest`) USING BTREE
) ENGINE=InnoDB COMMENT='反馈与建议';

CREATE TABLE `suzz-mini`.`suggest_picture_link` (
        `id` int NOT NULL AUTO_INCREMENT,
        `fk_suggest` int DEFAULT NULL COMMENT '建议id',
        `fk_picture` int DEFAULT NULL COMMENT '图片id',
        PRIMARY KEY (`id`),
        KEY `idx_fk_suggest` (`fk_suggest`) USING BTREE
) ENGINE=InnoDB COMMENT='反馈与建议图片关联表';

CREATE TABLE `suzz-mini`.`picture` (
       `id` int NOT NULL AUTO_INCREMENT,
       `fk_mini_user` int DEFAULT NULL COMMENT '用户id',
       `name` varchar(255) DEFAULT NULL COMMENT '图片名称',
       `url` varchar(1024)  DEFAULT NULL COMMENT '图片地址',
       `md5` varchar(255) DEFAULT NULL COMMENT 'md5验证重复',
       PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `line_subscribe` (
      `id` int NOT NULL AUTO_INCREMENT,
      `fk_mini_user` int DEFAULT NULL COMMENT '收藏的用户id',
      `departure_area_code` varchar(255) DEFAULT NULL COMMENT '出发区域code 6位数 2位省份2位城市 2位区域',
      `arrive_area_code` varchar(255) DEFAULT NULL COMMENT '目的区域code 6位数 2位省份2位城市 2位区域',
      `send` tinyint DEFAULT '0' COMMENT '0.未发送 1.已推送',
      `is_valid` tinyint(1) DEFAULT '1' COMMENT '1.有效 0.无效',
      PRIMARY KEY (`id`),
      KEY `idx_departure_area_code` (`departure_area_code`) USING BTREE,
      KEY `idx_arrive_area_code` (`arrive_area_code`) USING BTREE
) ENGINE=InnoDB COMMENT='线路订阅';

CREATE TABLE `line_subscribe_car_type` (
       `id` int NOT NULL AUTO_INCREMENT,
       `fk_line_subscribe` int DEFAULT NULL COMMENT '线路订阅id',
       `car_type` int DEFAULT NULL COMMENT '用车类型',
       PRIMARY KEY (`id`),
       KEY `idx_fk_line_subscribe` (`fk_line_subscribe`) USING BTREE
) ENGINE=InnoDB  COMMENT='订阅路线用车类型';

ALTER TABLE `suzz-mini`.`order`
    ADD INDEX `idx_publish_time`(`publish_time`) USING BTREE;


ALTER TABLE `suzz-mini`.`order`
    ADD COLUMN `is_load_location` int(0) DEFAULT '0' COMMENT '装货是否定位 0.不定位 1.定位' AFTER `publish_time`,
    ADD COLUMN `is_unload_location` int(0) DEFAULT '0' COMMENT '卸货是否定位 0.不定位 1.定位' AFTER `publish_time`,
    ADD COLUMN `load_address` varchar(255) COMMENT '装货详细地址' AFTER `is_load_location`,
    ADD COLUMN `unload_address` varchar(255) COMMENT '卸货详细地址' AFTER `is_unload_location`,
    ADD COLUMN `load_latitude` varchar(255) COMMENT '装货纬度' AFTER `load_address`,
    ADD COLUMN `load_longitude` varchar(255) COMMENT '装货经度' AFTER `load_address`,
    ADD COLUMN `unload_latitude` varchar(255) COMMENT '卸货纬度' AFTER `unload_address`,
    ADD COLUMN `unload_longitude` varchar(255) COMMENT '卸货经度' AFTER `unload_address`;

CREATE TABLE `sys_config` (
         `id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT,
         `param_key` VARCHAR ( 50 ) DEFAULT NULL COMMENT 'key',
         `param_value` MEDIUMTEXT COMMENT 'value',
         `remark` VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
         PRIMARY KEY ( `id` ) USING BTREE,
         UNIQUE KEY `key` ( `param_key` ) USING BTREE
) ENGINE = INNODB  COMMENT = '系统配置信息表';

CREATE TABLE `notice` (
      `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
      `content` varchar(255) DEFAULT NULL COMMENT '内容',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `agreement` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `name` varchar(255) DEFAULT NULL,
     `text` mediumtext,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE VIEW v_province_city_area AS SELECT
    CONCAT ( p.id, lpad ( c.`code`, 2, 0 ), lpad( a.`code`, 2, 0 ) ) all_code,
    CONCAT ( pl.`name`, cl.`name`, al.`name` ) all_name
FROM
    area a
        LEFT JOIN city c ON a.fk_city = c.id
        LEFT JOIN province p ON c.fk_province = p.id
        LEFT JOIN province_lang pl ON pl.fk_province = p.id
        LEFT JOIN city_lang cl ON c.id = cl.fk_city
        LEFT JOIN area_lang al ON al.fk_area = a.id
    where
    pl.lang = "chinese"
  AND cl.lang = "chinese"
  AND al.lang = "chinese"
