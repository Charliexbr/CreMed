/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : accompanycaredb

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 25/01/2025 11:34:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for caremed_service
-- ----------------------------
DROP TABLE IF EXISTS `caremed_service`;
CREATE TABLE `caremed_service`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `icon_image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `icon_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `logo_image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `logo_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `priceo` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `use_switch` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caremed_service
-- ----------------------------

-- ----------------------------
-- Table structure for clients
-- ----------------------------
DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `job` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `trait` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clients
-- ----------------------------
INSERT INTO `clients` VALUES (1, '张伟', 1, '3年骑手', '快速风雨无阻');
INSERT INTO `clients` VALUES (2, '李娜', 2, '5年助浴师', '温柔细心贴心');
INSERT INTO `clients` VALUES (3, '王芳', 2, '8年护士', '细心耐心有爱');

-- ----------------------------
-- Table structure for hospitals
-- ----------------------------
DROP TABLE IF EXISTS `hospitals`;
CREATE TABLE `hospitals`  (
  `id` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `rank` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `label` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `aid` bigint NULL DEFAULT NULL,
  `city` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `district` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospitals
-- ----------------------------
INSERT INTO `hospitals` VALUES (1, '陆军军医大学西南医院', '/uploads/20231105/341dcc6aca9679917a9fd50988a2f082.jpeg', '三甲', '综合医院', '烧伤科全国第一，心脑血管疾病诊治领先', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/index/chongqing/xinan.png', 1, '重庆市', '沙坪坝区', '沙坪坝区高滩岩正街30号');
INSERT INTO `hospitals` VALUES (2, '重庆医科大学附属第一医院', '/uploads/20231105/e22cd5cb3481e14bbdc52d9e237999.png', '三甲', '综合医院', '老年医学、肿瘤诊疗突出', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/index/chongqing/chongyifirst.png', 1, '重庆市', '渝中区', '渝中区袁家岗友谊路1号');
INSERT INTO `hospitals` VALUES (3, '陆军军医大学新桥医院', '/uploads/20231105/7adb06877e16ace0c3725e7e424496d.jpeg', '三甲', '综合医院', '呼吸内科、心血管外科全国领先', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/index/chongqing/xinqiao.png', 1, '重庆市', '沙坪坝区', '沙坪坝区新桥正街83号');
INSERT INTO `hospitals` VALUES (4, '陆军军医大学大坪医院', '/uploads/20231105/d64c396c15bd003d45f79e939180301c.jpeg', '三甲', '综合病院', '战创伤救治、神经外科突出', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/index/chongqing/daping.jpg', 1, '重庆市', '渝中区', '渝中区长江支路10号');
INSERT INTO `hospitals` VALUES (5, '重庆医科大学附属第二医院', '/uploads/20231105/308e36361cf273fdefe35c80c3134f92.jpeg', '三甲', '综合病院', '消化内科、心血管疾病诊治强', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/index/chongqing/chongyisecond.png', 1, '重庆市', '渝中区', '渝中区临江路76号');

-- ----------------------------
-- Table structure for my_staff
-- ----------------------------
DROP TABLE IF EXISTS `my_staff`;
CREATE TABLE `my_staff`  (
  `id` int NOT NULL,
  `nickname` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex_text` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `odmanar_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `master_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status_time_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_staff
-- ----------------------------
INSERT INTO `my_staff` VALUES (1, '小黄人', '/uploads/20231106/a2cb3d7d4cfe84c88c960b34664c22d3.jpeg', '1', 18, '18888888888', 'Sex 1', '', '', '', '', 'http://159.75.169.224/uploads/20231106/a2cb3d7d4cfe84c88c960b34664c22d3.jpeg');

-- ----------------------------
-- Table structure for nav2s
-- ----------------------------
DROP TABLE IF EXISTS `nav2s`;
CREATE TABLE `nav2s`  (
  `id` int NOT NULL,
  `pic_image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_link` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `tcolor` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `cat_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pic_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nav2s
-- ----------------------------
INSERT INTO `nav2s` VALUES (1, '/uploads/20231105/ac905fd8f9f1ca96ce614f0960a74820.png', '1', '/pages/hospital/index?hid=1', 'img1', '', '', 'Stype 1', 'http://159.75.169.224/uploads/20231105/ac905fd8f9f1ca96ce614f0960a74820.png');
INSERT INTO `nav2s` VALUES (2, '/uploads/20231105/299ec231895953ff27de0f63c7703f6b.png', '1', '/pages/hospital/index?hid=2', 'img2', '', '', 'Stype 1', 'http://159.75.169.224/uploads/20231105/299ec231895953ff27de0f63c7703f6b.png');

-- ----------------------------
-- Table structure for navs
-- ----------------------------
DROP TABLE IF EXISTS `navs`;
CREATE TABLE `navs`  (
  `id` int NOT NULL,
  `stype` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_link` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `tcolor` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `cat_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pic_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of navs
-- ----------------------------
INSERT INTO `navs` VALUES (3, '1', '/pages/service/index?svid=1&hid=5', '代跑取药', '', '', 'Stype 1', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/navs2/run.png');
INSERT INTO `navs` VALUES (4, '1', '/pages/service/index?svid=2&hid=5', '上门助浴', '', '', 'Stype 1', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/navs2/bath.png');
INSERT INTO `navs` VALUES (5, '1', '/pages/service/index?svid=3&hid=5', '半天陪诊', '', '', 'Stype 1', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/navs2/HalfDay.png');
INSERT INTO `navs` VALUES (6, '1', '/pages/service/index?svid=4&hid=5', '全天陪诊', '', '', 'Stype 1', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/navs2/FullDay.png');
INSERT INTO `navs` VALUES (7, '1', '/pages/service/index?svid=5&hid=5', '尊享陪诊', '', '', 'Stype 1', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/navs2/Exclusive.png');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `service_logo_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `service_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `hospital_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `area_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `client_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `trade_state` int NULL DEFAULT NULL,
  `service_stype` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for services
-- ----------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services`  (
  `id` int NOT NULL,
  `code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `stype` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `priceo` decimal(10, 2) NULL DEFAULT NULL,
  `use_switch` tinyint NULL DEFAULT NULL,
  `stype_text` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `icon_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of services
-- ----------------------------
INSERT INTO `services` VALUES (1, 'dp', '40', '代跑取药', '人工带跑取药，省时省力', 30.00, 100.00, 1, 'Stype 40', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/run.png');
INSERT INTO `services` VALUES (2, 'zy', '50', '上门助浴', '温馨助浴，关爱到家', 150.00, 300.00, 1, 'Stype 50', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/bath.jpg');
INSERT INTO `services` VALUES (3, 'pz', '15', '就医陪诊（半天）', '就医陪诊，值得托付', 100.00, 150.00, 1, 'Stype 15', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/HalfDay.jpeg');
INSERT INTO `services` VALUES (4, 'pz2', '15', '就医陪诊（全天）', '就医陪诊，值得托付', 200.00, 200.00, 1, 'Stype 15', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/FullDay.png');
INSERT INTO `services` VALUES (5, 'pz3', '15', '就医陪诊（尊享）', '就医陪诊，值得托付', 300.00, 500.00, 1, 'Stype 15', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/Exclusive.jpeg');

-- ----------------------------
-- Table structure for slides
-- ----------------------------
DROP TABLE IF EXISTS `slides`;
CREATE TABLE `slides`  (
  `id` int NOT NULL,
  `pic_image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_text` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pic_image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `stype_link` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of slides
-- ----------------------------
INSERT INTO `slides` VALUES (1, '/uploads/20231105/80221cd6111536ab328cda2ea0eef452.jpg', '0', 'banner01', 'Stype 0', 'http://159.75.169.224/uploads/20231105/80221cd6111536ab328cda2ea0eef452.jpg', NULL);
INSERT INTO `slides` VALUES (2, '/uploads/20231105/6a284b70666a936caca0af7f8268c9d8.jpg', '0', 'banner02', 'Stype 0', 'http://159.75.169.224/uploads/20231105/6a284b70666a936caca0af7f8268c9d8.jpg', NULL);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_id` int NOT NULL,
  `area_id` int NOT NULL,
  `user_id` int NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT 0,
  `age` int NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `idcardnum` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `idcards_images` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `papers_images` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `odmanar` tinyint(1) NULL DEFAULT 0,
  `master` tinyint(1) NULL DEFAULT 0,
  `master_uid` int NULL DEFAULT 0,
  `subs` int NULL DEFAULT 0,
  `money` decimal(10, 2) NULL DEFAULT 0.00,
  `income` decimal(10, 2) NULL DEFAULT 0.00,
  `income_service` decimal(10, 2) NULL DEFAULT 0.00,
  `income_master` decimal(10, 2) NULL DEFAULT 0.00,
  `outcash` decimal(10, 2) NULL DEFAULT 0.00,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NULL DEFAULT 20,
  `status_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status_remark` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `stop_switch` tinyint(1) NULL DEFAULT 0,
  `remark` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `sex_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `odmanar_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `master_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status_time_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `idcard_num` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `openid`(`openid` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 1, 1, 1, 'o_S0K5E18NjHVu_JT2gprCNghULY', '小黄人', '/uploads/20231106/a2cb3d7d4cfe84c88c960b34664c22d3.jpeg', 1, 18, '18888888888', '阿狸', '2233', '/uploads/20231105/e493dd36caf77e04060c9b430b148a3d.jpeg,/uploads/20231105/e493dd36caf77e04060c9b430b148a3d.jpeg', '', 0, 0, 0, 0, 0.06, 0.06, 0.06, 0.00, 0.00, '2023-11-05 15:08:52', '2023-12-05 13:02:02', 20, '2023-12-05 13:02:02', '通过', 0, '', 'Sex 1', 'Odmanar 0', 'Master 0', 'Status 20', '2023-12-05 13:02:02', 'http://159.75.169.224/uploads/20231106/a2cb3d7d4cfe84c88c960b34664c22d3.jpeg', NULL);

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics`  (
  `user_id` int NOT NULL,
  `topays` int NULL DEFAULT 0,
  `todos` int NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `statistics_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of statistics
-- ----------------------------
INSERT INTO `statistics` VALUES (1, 0, 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_id` int NOT NULL,
  `area_id` int NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `openid` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `province` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `district` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `orders` int NULL DEFAULT 0,
  `orders_cancel` int NULL DEFAULT 0,
  `orders_done` int NULL DEFAULT 0,
  `expends` decimal(10, 2) NULL DEFAULT 0.00,
  `admin_switch` tinyint(1) NULL DEFAULT 0,
  `seller_switch` tinyint(1) NULL DEFAULT 0,
  `black_switch` tinyint(1) NULL DEFAULT 0,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `invites` int NULL DEFAULT 0,
  `inviter_id` int NULL DEFAULT 0,
  `sells` int NULL DEFAULT 0,
  `sell_money` decimal(10, 2) NULL DEFAULT 0.00,
  `sell_income` decimal(10, 2) NULL DEFAULT 0.00,
  `sell_outcash` decimal(10, 2) NULL DEFAULT 0.00,
  `seller_id` int NULL DEFAULT 0,
  `seller_time` timestamp NULL DEFAULT NULL,
  `my_staff_id` int NULL DEFAULT 0,
  `_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `detailInfo` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `openid`(`openid` ASC) USING BTREE,
  UNIQUE INDEX `_id`(`_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 1, 1, '倍', 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/my/avatar1.jpg', '13079030357', 'o_S0K5E18NjHVu_JT2gprCNghULY', '', '重庆市', '渝中区', 7, 0, 6, 0.06, 0, 0, 0, '2023-11-05 14:01:58', '2025-01-24 17:31:11', '', 0, 0, 0, 0.00, 0.00, 0.00, 0, NULL, 1, '840MQ', 'http://159.75.169.224/uploads/20231106/a2cb3d7d4cfe84c88c960b34664c22d3.jpeg', '滨江路御景豪宅11栋');

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `before_insert_order`;
delimiter ;;
CREATE TRIGGER `before_insert_order` BEFORE INSERT ON `order` FOR EACH ROW BEGIN
    -- 根据 name 设置 icon_image_url
    IF NEW.service_name = '代跑取药' THEN
        SET NEW.service_logo_image_url = 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/run.png';
        SET NEW.service_stype = 40;
    ELSEIF NEW.service_name = '上门助浴' THEN
        SET NEW.service_logo_image_url = 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/bath.jpg';
        SET NEW.service_stype = 50;
    ELSEIF NEW.service_name = '就医陪诊（半天）' THEN
        SET NEW.service_logo_image_url = 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/HalfDay.jpeg';
        SET NEW.service_stype = 15;
    ELSEIF NEW.service_name = '就医陪诊（全天）' THEN
        SET NEW.service_logo_image_url = 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/FullDay.jpeg';
        SET NEW.service_stype = 15;
    ELSEIF NEW.service_name = '就医陪诊（专享）' THEN
        SET NEW.service_logo_image_url = 'https://vip.123pan.cn/1829447704/it_project/CareMed/uniapp/service/Exclusive.jpeg';
        SET NEW.service_stype = 15;
    END IF;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `set_area_name_before_insert`;
delimiter ;;
CREATE TRIGGER `set_area_name_before_insert` BEFORE INSERT ON `order` FOR EACH ROW BEGIN
    -- 根据 hospital_name 字段设置 area_name 的值
    IF NEW.hospital_name = '陆军军医大学西南医院' THEN
        SET NEW.area_name = '沙坪坝区';
    ELSEIF NEW.hospital_name = '重庆医科大学附属第一医院' THEN
        SET NEW.area_name = '渝中区';
    ELSEIF NEW.hospital_name = '陆军军医大学新桥医院' THEN
        SET NEW.area_name = '沙坪坝区';
    ELSEIF NEW.hospital_name = '陆军军医大学大坪医院' THEN
        SET NEW.area_name = '渝中区';
    ELSEIF NEW.hospital_name = '重庆医科大学附属第二医院' THEN
        SET NEW.area_name = '渝中区';
    END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
