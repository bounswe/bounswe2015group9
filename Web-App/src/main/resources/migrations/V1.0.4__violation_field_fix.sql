ALTER TABLE violation DROP COLUMN severity_rate;
ALTER TABLE violation ADD COLUMN `modification_date` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;