use `postgres`;
CREATE TABLE `usr` (
                          `id` INT auto_increment NOT NULL,
                          `accountName` varchar(128) NOT NULL,
                          `email` varchar(128) NOT NULL,
                          `password` varchar(128) NOT NULL,
                          PRIMARY KEY (`id`)
);



