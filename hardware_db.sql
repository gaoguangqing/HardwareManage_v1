/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.28 : Database - hardware_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hardware_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hardware_db`;

/*Table structure for table `mainframe` */

CREATE TABLE `mainframe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌',
  `name` varchar(500) DEFAULT NULL COMMENT '名称',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `mainframe` */

insert  into `mainframe`(`id`,`brand`,`name`,`price`,`amount`) values (1,'联想','联想品牌i3i5台式电脑主机家用商务办公学习电脑主机6bhPFE7Prh','1100',100),(2,'联想','全新联想i3i5台式电脑M4360M4500主机家用商务办公学习电脑主机','3050',200),(3,'联想','lenovo/联想台式机电脑 天逸510a G3900 i3 i5七代酷睿主机家用办公独显高端正版win10兼容win7','4999',150),(4,'联想','Lenovo/联想 Ideacentre 510A-15 办公家用客服台式电脑主机整套','5299',250),(5,'橙派','橙派i7 8700/GTX1060 6G/16G水冷游戏台式吃鸡DIY高配组装电脑主机','4987',50),(6,'武极','武极 i7 8700K升9700K/RTX2070/16G内存 水冷游戏台式吃鸡电脑主机DIY组装机','8887',20),(7,'武极','武极 AMD锐龙R5 2600/GTX1060-5G/华硕主板独显游戏台式吃鸡电脑主机/DIY组装机','3298',150),(8,'航向者','航向者 i7升E5八核水冷/GTX1060/16G DDR3吃鸡游戏台式组装电脑主机/DIY组装机 套三/八核水冷/16G/GTX1060-3G','3188',230),(9,'攀升','IPASON i7 8700/GTX1060 6G/16G独显吃鸡游戏台式DIY组装电脑主机全套','5145',100),(10,'雷霆世纪','雷霆世纪 复仇者V135S 六核i5-8400/GTX1050Ti/技嘉B360/DDR4 8G/240G SSD/吃鸡游戏主机/台式组装电脑UPC','4099',210),(11,'硕扬','硕扬 i7 8700/GTX1060显卡/16G内存/240G固态游戏台式吃鸡电脑主机/DIY组装机','3898',300),(12,'攀升','攀升IPASON i5 8500六核/GTX1060 6G吃鸡逆水寒游戏台式电脑主机/DIY组装机','3963',150);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
