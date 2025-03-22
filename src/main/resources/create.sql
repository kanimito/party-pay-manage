-- 创建党员表
CREATE TABLE party_member (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(50) NOT NULL,
                              gender CHAR(1) NOT NULL,
                              age INT NOT NULL,
                              join_party_time DATE NOT NULL,
                              party_organization VARCHAR(100) NOT NULL,
                              phone VARCHAR(20) NOT NULL,
                              email VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建党费标准表
CREATE TABLE party_fee_standard (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    organization_type VARCHAR(50) NOT NULL,
                                    income_type VARCHAR(50) NOT NULL,
                                    fee_rate DECIMAL(5,2) NOT NULL,
                                    fixed_amount DECIMAL(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建党费缴纳记录表
CREATE TABLE party_fee_payment (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   member_id INT NOT NULL,
                                   payment_time DATETIME NOT NULL,
                                   payment_amount DECIMAL(10,2) NOT NULL,
                                   payment_method VARCHAR(20) NOT NULL,
                                   payment_status VARCHAR(20) NOT NULL DEFAULT '已缴纳',
                                   FOREIGN KEY (member_id) REFERENCES party_member(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建系统用户表（用于管理员和党员登录，若使用Spring Security和JWT可参考此表进行认证授权）
CREATE TABLE system_user (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             username VARCHAR(50) NOT NULL UNIQUE,
                             password VARCHAR(255) NOT NULL,
                             user_type VARCHAR(20) NOT NULL, -- 取值如 '管理员', '党员'
                             member_id INT DEFAULT NULL,
                             FOREIGN KEY (member_id) REFERENCES party_member(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;