INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`)
VALUES (1, 1, 'department_city');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`)
VALUES (2, 1, 'arrive_city');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`)
VALUES (3, 1, 'please_department_city');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`)
VALUES (4, 1, 'please_arrive_city');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`)
VALUES (5, 1, 'page_bar_title');

INSERT INTO `suzz-mini`.`page_module_lang`(`id`, `fk_page_module`, `name`, `lang`)
VALUES (1, 1, '出发城市', 'chinese');
INSERT INTO `suzz-mini`.`page_module_lang`(`id`, `fk_page_module`, `name`, `lang`)
VALUES (2, 2, '目的城市', 'chinese');
INSERT INTO `suzz-mini`.`page_module_lang`(`id`, `fk_page_module`, `name`, `lang`)
VALUES (3, 3, '请选择出发城市', 'chinese');
INSERT INTO `suzz-mini`.`page_module_lang`(`id`, `fk_page_module`, `name`, `lang`)
VALUES (4, 4, '请选择目的城市', 'chinese');
INSERT INTO `suzz-mini`.`page_module_lang`(`id`, `fk_page_module`, `name`, `lang`)
VALUES (5, 5, '货源发布', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (6, '1','use_start_time');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (6, '使用开始时间', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (7, '1','tonnage');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (7, '吨位', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (8, '1','min_tonnage');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (8, '最小吨数', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (9, '1','max_tonnage');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (9, '最大吨数', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (10, '1','car_type_max_three');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (10, '用车类型(最多三项)', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (11, '1','price_style');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (11, '价格方式', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (12, '1','price');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (12, '价格', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (13, '1','please_input_price');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (13, '输入价格', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (14, '1','phone_meet');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (14, '电议', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (15, '1','goods_info');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (15, '货源信息', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (16, '1','please_supple_info');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (16, '请输入补充信息', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (17, '1','warm_prompt');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (17, '温馨提示:发布的时间超过5天自动下架', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (18, '1','publish');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (18, '发布', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (19, '2','remain_time');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (19, '上架剩余时间', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (20, '2','publish_content_is_empty');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (20, '发布内容为空', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (21, '2','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (21, '我的发布', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (22, '2','phone_meet');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (22, '电议', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (23, '2','price');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (23, '价格', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (24, '3','department_city');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (24, '出发城市', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (25, '3','arrive_city');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (25, '目的城市', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (26, '3','car_type_max_three');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (26, '用车类型(最多三项)', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (27, '3','price_style');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (27, '价格方式', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (28, '3','price');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (28, '价格', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (29, '3','please_input_price');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (29, '输入价格', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (30, '3','phone_meet');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (30, '电议', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (31, '3','goods_info');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (31, '货源信息', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (32, '3','warm_prompt');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (32, '温馨提示:发布的时间超过5天自动下架', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (33, '3','use_start_time');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (33, '使用开始时间', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (34, '3','tonnage');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (34, '吨位', 'chinese');
INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (35, '3','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (35, '发布详情', 'chinese');


INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (36, '4','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (36, '我的', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (37, '5','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (37, '货源资源', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (38, '6','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (38, '资源详情', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (39, '7','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (39, '反馈与建议', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (40, '8','service_complaints');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (40, '服务投诉', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (41, '9','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (41, '用户设置', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (42, '10','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (42, '订阅线路', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (43, '11','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (43, '添加常用线路', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (44, '12','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (44, '修改常用线路', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (45, '13','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (45, '收藏列表', 'chinese');

INSERT INTO `suzz-mini`.`page_module`(`id`, `fk_page`, `code`) VALUES (46, '14','page_bar_title');
INSERT INTO `suzz-mini`.`page_module_lang`(`fk_page_module`, `name`, `lang`) VALUES (46, '关注列表', 'chinese');

