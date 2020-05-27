CREATE DATABASE ip2location DEFAULT CHARACTER SET utf8 ;
USE ip2location;
CREATE TABLE `ip2location_db5`(
	`ip_from` BIGINT UNSIGNED,
	PRIMARY KEY (`ip_from`),
	`ip_to` BIGINT UNSIGNED,
	`country_code` CHAR(2),
	`country_name` VARCHAR(64),
	`region_name` VARCHAR(128),
	`city_name` VARCHAR(128),
	`latitude` DOUBLE,
	`longitude` DOUBLE,
	INDEX `idx_ip_from` (`ip_from`),
	INDEX `idx_ip_to` (`ip_to`),
	INDEX `idx_ip_from_to` (`ip_from`, `ip_to`)
);

LOAD DATA
	INFILE '/Users/ivan/IdeaProjects/geoip/src/main/resources/IP2LOCATION-LITE-DB5.csv'
INTO TABLE
	`ip2location_db5`
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 0 LINES;
