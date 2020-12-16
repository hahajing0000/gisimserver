/*
 Navicat Premium Data Transfer

 Source Server         : remotedb
 Source Server Type    : PostgreSQL
 Source Server Version : 130001
 Source Host           : 39.98.153.96:5432
 Source Catalog        : gisim
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130001
 File Encoding         : 65001

 Date: 16/12/2020 19:10:55
*/


-- ----------------------------
-- Sequence structure for seq_friend_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_friend_id";
CREATE SEQUENCE "public"."seq_friend_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_group_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_group_id";
CREATE SEQUENCE "public"."seq_group_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_groupmember_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_groupmember_id";
CREATE SEQUENCE "public"."seq_groupmember_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_grouptype_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_grouptype_id";
CREATE SEQUENCE "public"."seq_grouptype_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_localgroup_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_localgroup_id";
CREATE SEQUENCE "public"."seq_localgroup_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_msg_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_msg_id";
CREATE SEQUENCE "public"."seq_msg_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_msgtype_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_msgtype_id";
CREATE SEQUENCE "public"."seq_msgtype_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_user_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_user_id";
CREATE SEQUENCE "public"."seq_user_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for b_friend
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_friend";
CREATE TABLE "public"."b_friend" (
  "id" int4 NOT NULL DEFAULT nextval('seq_friend_id'::regclass),
  "userid" int4,
  "friendid" int4,
  "ctime" date,
  "addtype" int2,
  "alias" varchar(100) COLLATE "pg_catalog"."default",
  "localgroupid" int4,
  "status" int2
)
;
COMMENT ON COLUMN "public"."b_friend"."userid" IS '用户id';
COMMENT ON COLUMN "public"."b_friend"."friendid" IS '好友id';
COMMENT ON COLUMN "public"."b_friend"."ctime" IS '创建时间';
COMMENT ON COLUMN "public"."b_friend"."addtype" IS '添加方式 0-搜索添加 1-扫描添加 2-通讯录添加 ';
COMMENT ON COLUMN "public"."b_friend"."alias" IS '备注名称';
COMMENT ON COLUMN "public"."b_friend"."localgroupid" IS '本地分组id';
COMMENT ON COLUMN "public"."b_friend"."status" IS '状态 0-申请 1-同意 2-拒绝';

-- ----------------------------
-- Records of b_friend
-- ----------------------------
INSERT INTO "public"."b_friend" VALUES (1, 1, 22, NULL, 1, '11', 2, NULL);

-- ----------------------------
-- Table structure for b_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_group";
CREATE TABLE "public"."b_group" (
  "id" int4 NOT NULL DEFAULT nextval('seq_group_id'::regclass),
  "groupname" varchar(100) COLLATE "pg_catalog"."default",
  "groupdesc" varchar(200) COLLATE "pg_catalog"."default",
  "owner" int2,
  "grouptypeid" int2,
  "ctime" date,
  "imgpath" varchar(255) COLLATE "pg_catalog"."default",
  "grouptypename" varchar(100) COLLATE "pg_catalog"."default",
  "groupcode" varchar(20) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."b_group"."groupname" IS '群名称';
COMMENT ON COLUMN "public"."b_group"."groupdesc" IS '群描述';
COMMENT ON COLUMN "public"."b_group"."owner" IS '群主';
COMMENT ON COLUMN "public"."b_group"."grouptypeid" IS '群类型id';
COMMENT ON COLUMN "public"."b_group"."ctime" IS '创建时间';
COMMENT ON COLUMN "public"."b_group"."imgpath" IS '群头像地址';
COMMENT ON COLUMN "public"."b_group"."grouptypename" IS '群类型名称';
COMMENT ON COLUMN "public"."b_group"."groupcode" IS '群编码';

-- ----------------------------
-- Records of b_group
-- ----------------------------
INSERT INTO "public"."b_group" VALUES (1, '群组1', '群组1', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO "public"."b_group" VALUES (2, '三组开发', '三组', 456, 666, '2020-12-16', 'http://p1.music.126.net/yC_df5u0myXVp-bM99K3Lw==/5870292580832850.jpg', '开发', '007');
INSERT INTO "public"."b_group" VALUES (3, '三组开发', '三组', 456, 666, '2020-12-16', 'http://p1.music.126.net/yC_df5u0myXVp-bM99K3Lw==/5870292580832850.jpg', '开发', '007');

-- ----------------------------
-- Table structure for b_groupmember
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_groupmember";
CREATE TABLE "public"."b_groupmember" (
  "id" int4 NOT NULL DEFAULT nextval('seq_groupmember_id'::regclass),
  "memberid" int4,
  "groupid" int4,
  "isowner" int2,
  "isadmin" int2,
  "nick" varchar(100) COLLATE "pg_catalog"."default",
  "status" int2,
  "ctime" date
)
;
COMMENT ON COLUMN "public"."b_groupmember"."memberid" IS '群成员id 对应用户表id';
COMMENT ON COLUMN "public"."b_groupmember"."groupid" IS '群组id';
COMMENT ON COLUMN "public"."b_groupmember"."isowner" IS '是否群主 0-否 1-是';
COMMENT ON COLUMN "public"."b_groupmember"."isadmin" IS '是否管理员 0-否 1-是';
COMMENT ON COLUMN "public"."b_groupmember"."nick" IS '群昵称';
COMMENT ON COLUMN "public"."b_groupmember"."status" IS '状态 0-邀请进群 1-申请进群 2-同意进群|已进群 3-拒绝进群';
COMMENT ON COLUMN "public"."b_groupmember"."ctime" IS '创建时间';

-- ----------------------------
-- Records of b_groupmember
-- ----------------------------
INSERT INTO "public"."b_groupmember" VALUES (1, 1, 1, 1, NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for b_grouptype
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_grouptype";
CREATE TABLE "public"."b_grouptype" (
  "id" int4 NOT NULL DEFAULT nextval('seq_grouptype_id'::regclass),
  "typename" varchar(200) COLLATE "pg_catalog"."default",
  "ctime" date
)
;

-- ----------------------------
-- Records of b_grouptype
-- ----------------------------
INSERT INTO "public"."b_grouptype" VALUES (1, '交友', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (2, '游戏', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (3, '粉丝', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (4, '兴趣爱好', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (5, '生活休闲', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (6, '同学', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (7, '同事', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (8, '亲友', '2020-12-15');
INSERT INTO "public"."b_grouptype" VALUES (9, '家校', '2020-12-15');

-- ----------------------------
-- Table structure for b_localgroup
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_localgroup";
CREATE TABLE "public"."b_localgroup" (
  "id" int4 NOT NULL DEFAULT nextval('seq_localgroup_id'::regclass),
  "groupname" varchar(200) COLLATE "pg_catalog"."default",
  "membercount" int4,
  "groupdesc" varchar(255) COLLATE "pg_catalog"."default",
  "ctime" date,
  "userid" int4
)
;
COMMENT ON COLUMN "public"."b_localgroup"."groupname" IS '本地分组名称';
COMMENT ON COLUMN "public"."b_localgroup"."membercount" IS '组成员数量';
COMMENT ON COLUMN "public"."b_localgroup"."groupdesc" IS '组描述';
COMMENT ON COLUMN "public"."b_localgroup"."ctime" IS '创建时间';
COMMENT ON COLUMN "public"."b_localgroup"."userid" IS '用户id';

-- ----------------------------
-- Records of b_localgroup
-- ----------------------------
INSERT INTO "public"."b_localgroup" VALUES (2, '分组1', 10, '分组1', '2020-12-14', 1);

-- ----------------------------
-- Table structure for b_msg
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_msg";
CREATE TABLE "public"."b_msg" (
  "id" int4 NOT NULL DEFAULT nextval('seq_msg_id'::regclass),
  "content" text COLLATE "pg_catalog"."default" NOT NULL,
  "fromuser" int4 NOT NULL,
  "touser" int4 NOT NULL,
  "msgtypeid" int4 NOT NULL,
  "msgtype2" int2 NOT NULL,
  "ctime" timestamp(6) NOT NULL,
  "isread" int2 NOT NULL,
  "blltime" timestamp(6)
)
;
COMMENT ON COLUMN "public"."b_msg"."content" IS '消息内容';
COMMENT ON COLUMN "public"."b_msg"."fromuser" IS '发送用户';
COMMENT ON COLUMN "public"."b_msg"."touser" IS '接收用户';
COMMENT ON COLUMN "public"."b_msg"."msgtypeid" IS '消息类型';
COMMENT ON COLUMN "public"."b_msg"."msgtype2" IS '0-发送消息 1-接收消息';
COMMENT ON COLUMN "public"."b_msg"."ctime" IS '创建时间';
COMMENT ON COLUMN "public"."b_msg"."isread" IS '是否读取 0-未读 1-已读';
COMMENT ON COLUMN "public"."b_msg"."blltime" IS '发送或者接收时间';

-- ----------------------------
-- Records of b_msg
-- ----------------------------
INSERT INTO "public"."b_msg" VALUES (3, '22', 2, 1, 1, 1, '2020-12-16 18:36:29', 0, '2020-12-16 18:36:33');
INSERT INTO "public"."b_msg" VALUES (2, '11', 1, 2, 1, 1, '2020-12-16 18:36:13', 0, '2020-12-16 18:36:16');
INSERT INTO "public"."b_msg" VALUES (4, '22', 2, 3, 1, 1, '2020-12-16 18:36:59', 1, '2020-12-16 18:37:03');
INSERT INTO "public"."b_msg" VALUES (5, '你好', 1, 2, 1, 1, '2020-12-16 19:01:25.564799', 0, '2020-12-16 18:36:59');

-- ----------------------------
-- Table structure for b_msgtype
-- ----------------------------
DROP TABLE IF EXISTS "public"."b_msgtype";
CREATE TABLE "public"."b_msgtype" (
  "id" int4 NOT NULL DEFAULT nextval('seq_msgtype_id'::regclass),
  "msgtypecode" int2 NOT NULL,
  "msgtypename" varchar(20) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."b_msgtype"."msgtypecode" IS '消息类型编码';
COMMENT ON COLUMN "public"."b_msgtype"."msgtypename" IS '消息类型名称';

-- ----------------------------
-- Records of b_msgtype
-- ----------------------------
INSERT INTO "public"."b_msgtype" VALUES (1, 1, '文本消息');
INSERT INTO "public"."b_msgtype" VALUES (2, 2, '图片消息');
INSERT INTO "public"."b_msgtype" VALUES (3, 3, '表情符号');
INSERT INTO "public"."b_msgtype" VALUES (4, 4, '短语音');
INSERT INTO "public"."b_msgtype" VALUES (5, 5, '短视频');
INSERT INTO "public"."b_msgtype" VALUES (6, 6, '位置');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."s_user";
CREATE TABLE "public"."s_user" (
  "id" int4 NOT NULL DEFAULT nextval('seq_user_id'::regclass),
  "phonenumber" varchar(100) COLLATE "pg_catalog"."default",
  "pwd" varchar(50) COLLATE "pg_catalog"."default",
  "nick" varchar(100) COLLATE "pg_catalog"."default",
  "headimg" varchar(200) COLLATE "pg_catalog"."default",
  "lastlocation" point,
  "imaccount" varchar(200) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."s_user"."phonenumber" IS '电话号码';
COMMENT ON COLUMN "public"."s_user"."pwd" IS '密码';
COMMENT ON COLUMN "public"."s_user"."nick" IS '昵称';
COMMENT ON COLUMN "public"."s_user"."headimg" IS '头像';
COMMENT ON COLUMN "public"."s_user"."lastlocation" IS '最后一次位置';
COMMENT ON COLUMN "public"."s_user"."imaccount" IS 'IM系统对应关联账号';

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO "public"."s_user" VALUES (22, '123', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (23, '123123', '123123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (24, '176123', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (25, '1233', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (26, '1530557082', '123456', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (35, 'zxy', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (37, '159', '159', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (38, 'gwegwhw', 'whwhwh', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (39, 'gqgqg', 'gqgqgq', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (40, 'geqgqg', 'gqgqgqg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (41, 'bbww', 'wnwn', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (42, 'wwwww', 'wwww', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (43, '13681855692', '2222', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (44, '13817178149', '111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (45, '13812345678', 'gqqgqgq', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (46, '13121905302', 'qgqgqg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (47, '18251514385', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (48, '13681855693', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (52, 'zhy', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (1, '18666661111', '123', '哈哈镜', '1', '(123,321)', NULL);
INSERT INTO "public"."s_user" VALUES (55, '123456789', '123456789', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (56, '12345678911', '123456789', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (57, '123456789112', '123456789', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (58, '1gwh59', '1whh59', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (59, 'gqegqhqgqhh', 'ghqhqhqh', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (60, 'vqgqgqgqg', 'qgqgqgqg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (61, '123321', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (62, '456', '456', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (63, '123321123', '123321123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (64, '111111111', '111111111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (65, '123456', '123456', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (66, '125', '1', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (67, '...1123..', '...1123..', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (68, '12345678900', '123456', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (69, '12345678999', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (70, '112233', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (71, '741852963', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (72, '1.1', '111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (73, '1.2', '111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (74, '1.3', '111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (75, '1.4', '111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (76, '1.5', '111', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (77, '1731256', '123', NULL, NULL, NULL, NULL);
INSERT INTO "public"."s_user" VALUES (78, '789', '789', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_friend_id"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_group_id"', 4, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_groupmember_id"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_grouptype_id"', 10, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_localgroup_id"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_msg_id"', 6, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_msgtype_id"', 7, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."seq_user_id"', 79, true);

-- ----------------------------
-- Primary Key structure for table b_friend
-- ----------------------------
ALTER TABLE "public"."b_friend" ADD CONSTRAINT "b_friend_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table b_group
-- ----------------------------
ALTER TABLE "public"."b_group" ADD CONSTRAINT "b_group_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table b_groupmember
-- ----------------------------
ALTER TABLE "public"."b_groupmember" ADD CONSTRAINT "b_groupmember_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table b_grouptype
-- ----------------------------
ALTER TABLE "public"."b_grouptype" ADD CONSTRAINT "b_grouptype_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table b_localgroup
-- ----------------------------
ALTER TABLE "public"."b_localgroup" ADD CONSTRAINT "b_localgroup_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table b_msg
-- ----------------------------
ALTER TABLE "public"."b_msg" ADD CONSTRAINT "b_msg_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table b_msgtype
-- ----------------------------
ALTER TABLE "public"."b_msgtype" ADD CONSTRAINT "b_msgtype_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table s_user
-- ----------------------------
ALTER TABLE "public"."s_user" ADD CONSTRAINT "s_user_pkey" PRIMARY KEY ("id");
