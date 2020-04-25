CREATE TABLE `distributed_lock` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT '1' COMMENT '次数',
  `resouce_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源名称',
  `des` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;