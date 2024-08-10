CREATE TABLE IF NOT EXISTS `loans` (
    `loan_id` int NOT NULL AUTO_INCREMENT,
    `mobile` varchar(15) NOT NULL,
    `loan_number` varchar(100) NOT NULL,
    `loan_type` varchar(100) NOT NULL,
    `total_loan` int NOT NULL,
    `amount_paid` int NOT NULL,
    `outstanding_amount` int NOT NULL,
    `create_time` date NOT NULL,
    `create_user` varchar(20) NOT NULL,
    `update_time` date DEFAULT NULL,
    `update_user` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`loan_id`)
    );