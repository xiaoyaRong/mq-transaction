CREATE TABLE `parkingRecord` (
                               `id` varchar(55) NOT NULL,
                               `plateNumber` varchar(255) DEFAULT NULL,
                               `entranceTime` datetime DEFAULT NULL,
                               `leavingTime` datetime DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;