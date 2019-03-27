/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.61 : Database - cryptolaliadb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cryptolaliadb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cryptolaliadb`;

/*Table structure for table `tb_link` */

DROP TABLE IF EXISTS `tb_link`;

CREATE TABLE `tb_link` (
  `userID` char(32) DEFAULT NULL COMMENT '用户ID',
  `linkUserID` char(32) DEFAULT NULL COMMENT '联系人用户ID',
  `status` tinyint(1) DEFAULT '0' COMMENT '关系状态 0好友未通过 1好友 2删除',
  KEY `userID` (`userID`),
  KEY `linkUserID` (`linkUserID`),
  CONSTRAINT `tb_link_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `tb_user` (`userID`),
  CONSTRAINT `tb_link_ibfk_2` FOREIGN KEY (`linkUserID`) REFERENCES `tb_user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联系人';

/*Data for the table `tb_link` */

insert  into `tb_link`(`userID`,`linkUserID`,`status`) values ('91bf33adc5b74dc79acd0108bfa38e50','256f20205336406d869c21a1d08278d7',1),('256f20205336406d869c21a1d08278d7','91bf33adc5b74dc79acd0108bfa38e50',1),('a3a9e5ac70974a7b8e91e7d50309ebad','256f20205336406d869c21a1d08278d7',1),('a3a9e5ac70974a7b8e91e7d50309ebad','91bf33adc5b74dc79acd0108bfa38e50',1),('256f20205336406d869c21a1d08278d7','a3a9e5ac70974a7b8e91e7d50309ebad',1),('91bf33adc5b74dc79acd0108bfa38e50','a3a9e5ac70974a7b8e91e7d50309ebad',1),('ff7d9d6d1ef24adcab55fbd880cd237e','256f20205336406d869c21a1d08278d7',1),('ff7d9d6d1ef24adcab55fbd880cd237e','91bf33adc5b74dc79acd0108bfa38e50',1),('256f20205336406d869c21a1d08278d7','ff7d9d6d1ef24adcab55fbd880cd237e',1),('91bf33adc5b74dc79acd0108bfa38e50','ff7d9d6d1ef24adcab55fbd880cd237e',1);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `userID` char(32) NOT NULL COMMENT '用户ID',
  `headImg` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `username` varchar(15) NOT NULL COMMENT '账号',
  `password` varchar(18) NOT NULL COMMENT '密码',
  `nickname` varchar(10) NOT NULL COMMENT '昵称',
  `phone` char(11) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`userID`,`headImg`,`username`,`password`,`nickname`,`phone`) values ('256f20205336406d869c21a1d08278d7','headImg/ba64868cdd3d4c1788d85de28178bddc.png','13719664496','1','王百逸','13719664496'),('91bf33adc5b74dc79acd0108bfa38e50','headImg/ba64868cdd3d4c1788d85de28178bddc.png','1332783374','123456','tan','1332783374'),('a3a9e5ac70974a7b8e91e7d50309ebad','headImg/ba64868cdd3d4c1788d85de28178bddc.png','13143625426','1','王百逸2','13143625426'),('ff7d9d6d1ef24adcab55fbd880cd237e','headImg/ba64868cdd3d4c1788d85de28178bddc.png','13060826414','13060826414','在吗','13060826414');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
