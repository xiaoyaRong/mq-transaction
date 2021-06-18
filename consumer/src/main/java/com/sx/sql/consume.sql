CREATE TABLE `prePayment` (
                            `id` int(255) NOT NULL AUTO_INCREMENT,
                            `amount` decimal(10,2) DEFAULT NULL,
                            `payStatus` tinyint(1) DEFAULT NULL COMMENT '0未支付 1已支付',
                            `parkingId` varchar(55) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `parkingRecordMqSend` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `parkingRecordId` varchar(55) NOT NULL,
                                     `plateNumber` varchar(255) DEFAULT NULL,
                                     `body` varchar(1024) DEFAULT NULL,
                                     `sendStatus` tinyint(1) DEFAULT NULL COMMENT '状态0:未确认 1:确认',
                                     `sendTimes` int(10) DEFAULT NULL COMMENT '发送次数',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;