CREATE TABLE `users` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `profilepic` varchar(255),
  `password` varchar(255) NOT NULL,
  `role` roleType_id,
  `bio` varchar(255)
);

CREATE TABLE `roleType` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `role` varchar(255)
);

CREATE TABLE `address` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `street` varchar(255),
  `city` varchar(255),
  `state` state_id,
  `zipcode` varchar(10),
  `primary` boolean
);

CREATE TABLE `stateType` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `state` char(2)
);

CREATE TABLE `userAddress` (
  `user` user_id,
  `address` address_id
);

CREATE TABLE `phone` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `type` phoneType_id,
  `primary` boolean
);

CREATE TABLE `phoneType` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `type` varchar(255)
);

CREATE TABLE `userPhone` (
  `user` user_id,
  `phone` phone_id
);

CREATE TABLE `schoolPhone` (
  `school` school_id,
  `phone` phone_id
);

CREATE TABLE `email` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `email` varchar(255),
  `primary` boolean
);

CREATE TABLE `userEmail` (
  `user` user_id,
  `email` email_id
);

CREATE TABLE `schoolEmail` (
  `school` school_id,
  `email` email_id
);

CREATE TABLE `course` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `teacher` teacher_id,
  `school` school_id,
  `creditHours` double,
  `totalPoints` integer,
  `coursename` varchar(255),
  `summary` varchar(255)
);

CREATE TABLE `studentCourse` (
  `student` student_id,
  `course` course_id
);

CREATE TABLE `teacherCourse` (
  `teacher` teacher_id,
  `course` course_id
);

CREATE TABLE `schoolCourse` (
  `course` course_id,
  `school` school_id
);

CREATE TABLE `staffSchool` (
  `staff` user_id,
  `school` school_id
);

CREATE TABLE `school` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `schoolname` varchar(255),
  `address` address_id,
  `campuslogo` varchar(255)
);

CREATE TABLE `grades` (
  `student` student_id,
  `teacher` teacher_id,
  `date` date,
  `course` course_id,
  `grade` integer
);

CREATE TABLE `homeworkAssign` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `course` course_id,
  `name` varchar(255),
  `dateissued` date,
  `datedue` date,
  `summary` varchar(255)
);

CREATE TABLE `homeworkUpload` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `student` users_id,
  `homeworkAssign` homeworkAssign_id,
  `dateuploaded` date,
  `url` varchar(255)
);

CREATE TABLE `homeworkResources` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `attachhomework` homeworkAssign_id,
  `url` varchar(255)
);

CREATE TABLE `salaryType` (
  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `staff` user_id,
  `type` varchar(255),
  `amount` double
);

ALTER TABLE `users` ADD FOREIGN KEY (`role`) REFERENCES `roleType` (`id`);

ALTER TABLE `address` ADD FOREIGN KEY (`state`) REFERENCES `stateType` (`id`);

ALTER TABLE `userAddress` ADD FOREIGN KEY (`user`) REFERENCES `users` (`id`);

ALTER TABLE `userAddress` ADD FOREIGN KEY (`address`) REFERENCES `address` (`id`);

ALTER TABLE `phone` ADD FOREIGN KEY (`type`) REFERENCES `phoneType` (`id`);

ALTER TABLE `userPhone` ADD FOREIGN KEY (`user`) REFERENCES `users` (`id`);

ALTER TABLE `userPhone` ADD FOREIGN KEY (`phone`) REFERENCES `phone` (`id`);

ALTER TABLE `schoolPhone` ADD FOREIGN KEY (`school`) REFERENCES `school` (`id`);

ALTER TABLE `schoolPhone` ADD FOREIGN KEY (`phone`) REFERENCES `phone` (`id`);

ALTER TABLE `userEmail` ADD FOREIGN KEY (`user`) REFERENCES `users` (`id`);

ALTER TABLE `userEmail` ADD FOREIGN KEY (`email`) REFERENCES `email` (`id`);

ALTER TABLE `schoolEmail` ADD FOREIGN KEY (`school`) REFERENCES `school` (`id`);

ALTER TABLE `schoolEmail` ADD FOREIGN KEY (`email`) REFERENCES `email` (`id`);

ALTER TABLE `course` ADD FOREIGN KEY (`teacher`) REFERENCES `users` (`id`);

ALTER TABLE `course` ADD FOREIGN KEY (`school`) REFERENCES `school` (`id`);

ALTER TABLE `studentCourse` ADD FOREIGN KEY (`student`) REFERENCES `users` (`id`);

ALTER TABLE `studentCourse` ADD FOREIGN KEY (`course`) REFERENCES `course` (`id`);

ALTER TABLE `teacherCourse` ADD FOREIGN KEY (`teacher`) REFERENCES `users` (`id`);

ALTER TABLE `teacherCourse` ADD FOREIGN KEY (`course`) REFERENCES `course` (`id`);

ALTER TABLE `schoolCourse` ADD FOREIGN KEY (`course`) REFERENCES `course` (`id`);

ALTER TABLE `schoolCourse` ADD FOREIGN KEY (`school`) REFERENCES `school` (`id`);

ALTER TABLE `staffSchool` ADD FOREIGN KEY (`staff`) REFERENCES `users` (`id`);

ALTER TABLE `staffSchool` ADD FOREIGN KEY (`school`) REFERENCES `school` (`id`);

ALTER TABLE `school` ADD FOREIGN KEY (`address`) REFERENCES `address` (`id`);

ALTER TABLE `grades` ADD FOREIGN KEY (`student`) REFERENCES `users` (`id`);

ALTER TABLE `grades` ADD FOREIGN KEY (`teacher`) REFERENCES `users` (`id`);

ALTER TABLE `grades` ADD FOREIGN KEY (`course`) REFERENCES `course` (`id`);

ALTER TABLE `homeworkAssign` ADD FOREIGN KEY (`course`) REFERENCES `course` (`id`);

ALTER TABLE `homeworkUpload` ADD FOREIGN KEY (`student`) REFERENCES `users` (`id`);

ALTER TABLE `homeworkUpload` ADD FOREIGN KEY (`homeworkAssign`) REFERENCES `homeworkAssign` (`id`);

ALTER TABLE `homeworkResources` ADD FOREIGN KEY (`attachhomework`) REFERENCES `homeworkAssign` (`id`);

ALTER TABLE `salaryType` ADD FOREIGN KEY (`staff`) REFERENCES `users` (`id`);
