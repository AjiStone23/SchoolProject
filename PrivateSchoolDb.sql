CREATE DATABASE PrivateSchoolProject;

USE  PrivateSchoolProject;

-- ********************************************************************* TimeType

CREATE TABLE TimeType
(
 timeTypeId integer NOT NULL AUTO_INCREMENT ,
 timeTypeDescription  varchar(45) NOT NULL UNIQUE ,

PRIMARY KEY (timeTypeId)
) ;

-- ************************************************************ Course

CREATE TABLE Course
(
 courseId   integer NOT NULL AUTO_INCREMENT ,
 courseTitle      varchar(45) NOT NULL  ,
 start_Date date NOT NULL ,
 end_Date   date NOT NULL , 
 timeTypeId integer NOT NULL ,

PRIMARY KEY (courseId),
FOREIGN KEY (timeTypeId) REFERENCES TimeType (timeTypeId),
UNIQUE KEY uniqueCourse  (courseTitle,start_Date,end_Date,timeTypeId),
 
CONSTRAINT `after_start_Date` CHECK ( end_Date >= start_Date)
);

-- ***************************************************************** 'Stream'

CREATE TABLE Stream
(
 streamId    integer NOT NULL AUTO_INCREMENT ,
 streamTitle varchar(45) NOT NULL UNIQUE ,

PRIMARY KEY (streamId)
) ;

-- ****************************************************************** `CourseAssignment`

CREATE TABLE CourseAssignment
(
 assignmentId       integer NOT NULL AUTO_INCREMENT ,
 assignmentTitle    varchar(45) NOT NULL ,
 assignmentDescription    varchar(200) NOT NULL ,
 deadline                 date NOT NULL ,
 maxOralMark              integer NOT NULL ,
 maxTotalMark             integer NOT NULL ,
 courseId                 integer DEFAULT 0  ,

PRIMARY KEY (assignmentId),
FOREIGN KEY (courseId) REFERENCES Course (courseId),
UNIQUE KEY uniqueAssignment  (assignmentTitle,courseId)

) ;




-- ********************************************************************** `Subject`

CREATE TABLE Subject
(
 subjectId    integer NOT NULL AUTO_INCREMENT ,
 subjectTitle varchar(45) NOT NULL UNIQUE ,

PRIMARY KEY (subjectId)
) ;

-- ************************************************************************ `CoursePerStream`

CREATE TABLE CoursePerStream
(
 courseId integer NOT NULL ,
 streamId integer NOT NULL ,

PRIMARY KEY (courseId, streamId),

 FOREIGN KEY (courseId) REFERENCES Course (courseId),
  FOREIGN KEY (streamId) REFERENCES Stream (streamId)
);


-- *********************************************************************** `Student`

CREATE TABLE Student
(
 studentId   integer NOT NULL AUTO_INCREMENT ,
 firstName   varchar(25) NOT NULL ,
 lastName    varchar(25) NOT NULL ,
 dateOfBirth date NOT NULL , 
 tuitionFees  decimal(10,2) DEFAULT 0 ,
PRIMARY KEY (studentId),
UNIQUE KEY uniqueStudent (firstName,lastName,dateOfBirth)
) ;






-- ***************************************************************************** `StudentAssignment`

CREATE TABLE StudentAssignment
(
 studentId          integer NOT NULL ,
 assignmentId     integer NOT NULL ,
 subDateTime        date NULL ,
 oralMark           integer DEFAULT 0,
 totalMark     integer NULL DEFAULT 0, 

 PRIMARY KEY (studentId, assignmentId),
 FOREIGN KEY  (studentId) REFERENCES Student (studentId),
 FOREIGN KEY  (assignmentId) REFERENCES CourseAssignment (assignmentId)
);



-- ******************************************************************************** `Trainer`


CREATE TABLE Trainer
(
 trainerId   integer NOT NULL AUTO_INCREMENT ,
 firstName   varchar(25) NOT NULL ,
 lastName    varchar(25) NOT NULL ,
 dateOfBirth date NOT NULL  , 
 subjectId   integer NOT NULL ,

PRIMARY KEY (trainerId),
 FOREIGN KEY (subjectId) REFERENCES  Subject (subjectId),
 UNIQUE KEY uniqueStudent (firstName,lastName,dateOfBirth)
);

-- ********************************************************************************* `ClassRoom`

CREATE TABLE ClassRoom
(
 classRoomId    integer NOT NULL AUTO_INCREMENT ,
 classRoomTitle varchar(45) NOT NULL UNIQUE,
 courseId       integer NOT NULL ,

PRIMARY KEY (classRoomId),
FOREIGN KEY (courseId) REFERENCES Course (courseId)
) ;


-- ************************************************************************** `TrainerPerClassRoom`

CREATE TABLE TrainerPerClassRoom
(
 trainerId   integer NOT NULL ,
 classRoomId integer NOT NULL ,


PRIMARY KEY (trainerId, classRoomId),
FOREIGN KEY  (trainerId) REFERENCES Trainer (trainerId),
FOREIGN KEY   (classRoomId) REFERENCES ClassRoom (classRoomId)
);


-- *********************************************************************** `StudentPerClassRoom`

CREATE TABLE StudentPerClassRoom
(
 studentId   integer NOT NULL ,
 classRoomId integer NOT NULL ,

PRIMARY KEY (studentId, classRoomId),
FOREIGN KEY  (studentId) REFERENCES Student (studentId),
FOREIGN KEY (classRoomId) REFERENCES ClassRoom(classRoomId)
);

-- *******************************************************************************TRIGGERS


DELIMITER ((
 CREATE TRIGGER invalid_future_startDate BEFORE INSERT ON Course
   FOR EACH ROW
   BEGIN
	IF NEW.start_Date <= curdate()
	THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END;
    ((



DELIMITER **

CREATE TRIGGER after_student_enroll 
   AFTER INSERT ON studentperclassroom
    FOR EACH ROW 
    BEGIN
 INSERT INTO studentassignment(studentId,assignmentId)
 SELECT NEW.studentId , assignmentId
 FROM   courseassignment 
 WHERE courseassignment.courseId IN (SELECT courseId from ClassRoom
	WHERE classroomId=NEW.classRoomId);
     END;
**


DELIMITER **

CREATE TRIGGER after_insert_courseassignment 
   AFTER INSERT ON courseassignment 
    FOR EACH ROW 
    BEGIN
 INSERT INTO studentassignment (studentId,assignmentId)
 SELECT sc.studentId , NEW.assignmentId
 FROM   courseassignment ca
 INNER JOIN course c ON ca.courseid=c.courseid
 INNER JOIN classroom cl ON c.courseid=cl.courseid
 INNER JOIN studentperclassroom sc on cl.classroomid=sc.classroomid
 WHERE ca.courseId =NEW.courseid
 AND  ca.assignmentid=NEW.assignmentid ;
	
     END;
**







DELIMITER ^^
  
    CREATE TRIGGER invalid_Trainer_dateOfBirth BEFORE INSERT ON Trainer
    FOR EACH ROW
    BEGIN 
	IF NEW.dateOfBirth >= CURDATE()
	THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END
	^^
    
    DELIMITER ((
 CREATE TRIGGER invalid_Student_dateOfBirth BEFORE INSERT ON Student
   FOR EACH ROW
   BEGIN
	IF NEW.dateOfBirth>= CURDATE()
	THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END;
    ((
    
    DELIMITER %%
 CREATE TRIGGER invalid_Student_fees BEFORE INSERT ON Student
   FOR EACH ROW
   BEGIN
	IF NEW.tuitionFees < 0
	THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END;
    %%
    
    
    

DELIMITER $$
 CREATE TRIGGER between_course_dates BEFORE INSERT ON CourseAssignment
   FOR EACH ROW
   BEGIN
	IF NEW.deadline < (SELECT start_Date FROM course WHERE  course.courseId=NEW.courseId)
         OR  NEW.deadline > (SELECT end_Date FROM course WHERE course.courseId=NEW.courseId)
       THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END;
    $$
    
    
    DELIMITER &&
 CREATE TRIGGER invalid_StudentAssignment_Mark BEFORE INSERT ON StudentAssignment
   FOR EACH ROW
   BEGIN
	IF NEW.oralMark>(SELECT maxOralMark FROM CourseAssignment 
                     WHERE CourseAssignment.assignmentId=NEW.assignmentId )
	OR
	    NEW.totalMark>(SELECT maxTotalMark FROM CourseAssignment 
					  WHERE CourseAssignment.assignmentId=NEW.assignmentId)   
	THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END;
    &&
    
    
      DELIMITER &&
 CREATE TRIGGER invalid_Update_StudentAssignment_Mark BEFORE UPDATE ON StudentAssignment
   FOR EACH ROW
   BEGIN
	IF NEW.oralMark>(SELECT maxOralMark FROM CourseAssignment 
                     WHERE CourseAssignment.assignmentId=NEW.assignmentId )
	OR
	    NEW.totalMark>(SELECT maxTotalMark FROM CourseAssignment 
					  WHERE CourseAssignment.assignmentId=NEW.assignmentId)   
	THEN
	SIGNAL SQLSTATE '45000';
    END IF;
    END;
    &&
    
    -- *************************************************************************VIEWS
    DELIMITER $$
    
	CREATE VIEW TRAINERVIEW AS
    SELECT trainerId,firstName,lastName,dateOfBirth,subjectTitle
    FROM TRAINER t INNER JOIN
    subject s on  t.subjectid=s.subjectid;

    CREATE VIEW COURSEASSIGNMENTVIEW AS
    SELECT assignmentId,assignmentTitle,assignmentDescription,
    deadline,maxOralMark,maxTotalMark,courseTitle
    FROM courseassignment ca INNER JOIN
    course c on  ca.courseid=c.courseid;
    
   
    CREATE VIEW STUDENTASSIGNMENTVIEW AS
    SELECT ca.assignmentId,sa.studentid,ca.assignmentTitle,c.courseTitle,
    ca.deadline ,sa.subdatetime,ca.maxOralMark,ca.maxTotalMark,sa.oralmark,sa.totalmark
	FROM   course c   INNER JOIN
    courseassignment ca
	on  c.courseid=ca.courseid
    INNER JOIN
    studentassignment sa
    on ca.assignmentid=sa.assignmentid;
    
    
        
    CREATE VIEW CLASSROOMVIEW AS 
    SELECT cl.classRoomId  ,cl.classRoomTitle,co.courseTitle,co.start_Date,co.end_Date,
    t.timeTypeDescription, temp.enrolled
    FROM classroom cl LEFT JOIN  
    course co on cl.courseid=co.courseid  
    INNER JOIN timetype t on co.timetypeid=t.timetypeid
     LEFT JOIN (SELECT COUNT(*) enrolled , classroomid FROM
    studentperclassroom GROUP BY classroomid) as temp
    ON cl.classroomid=temp.classroomid;
    
    CREATE VIEW COURSEVIEW AS
    SELECT c.courseId, c.courseTitle, c.start_Date, c.end_Date ,t.timeTypedescription, studentnumber
    FROM course c INNER JOIN timetype t ON
    c.timetypeid=t.timetypeid LEFT JOIN
    (SELECT COUNT(*) studentnumber,courseid  FROM (SELECT sc.studentid , cl.courseid FROM 
    studentperclassroom sc INNER
    JOIN classroom cl ON sc.classroomid=cl.classroomid
    ) AS temp
    group by courseid) as temp2
    ON   c.courseid=temp2.courseid;
    
    
    CREATE VIEW STREAMVIEW AS
    SELECT  s.streamid,s.streamtitle,temp.coursecount
    FROM stream s LEFT JOIN 
    (SELECT COUNT(*) coursecount, streamid FROM 
    courseperstream group by streamid) as temp
    ON s.streamid=temp.streamid;
    
$$
    
-- *******************************************************************PROCEDURES   
    
    DELIMITER //

CREATE PROCEDURE deletestudent(inputid INT)
BEGIN
	DELETE sa FROM studentassignment sa
    where sa.studentid=inputid;
    DELETE sc FROM studentperclassroom sc
    WHERE sc.studentid=inputid;
    DELETE s FROM student s
    WHERE s.studentid=inputid;
    END ;
      //


      
    DELIMITER //

CREATE PROCEDURE deletetrainer(inputid INT)
BEGIN
	DELETE tc FROM trainerperclassroom tc
    where tc.trainerid=inputid;
    DELETE t FROM trainer t
    WHERE t.trainerid=inputid;
    
    END ;
      //
    
    
    
         
    DELIMITER //

CREATE PROCEDURE deleteclassroom(inputid INT)
BEGIN
	DELETE tc FROM trainerperclassroom tc
    where tc.classroomid=inputid;
    DELETE sc FROM studentperclassroom sc
    WHERE sc.classroomid=inputid;
    DELETE c FROM classroom c
    WHERE c.classroomid=inputid;
    END ;
      //
      
    
     DELIMITER //
    
CREATE PROCEDURE deletecourse(inputid INT)
BEGIN
DECLARE fetchedid INT;
DECLARE done INT DEFAULT 0;
DECLARE cur1 CURSOR FOR SELECT cl.classroomid FROM classroom cl
WHERE cl.courseid=inputid;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

	DELETE cs FROM courseperstream cs
    WHERE cs.courseid=inputid;
    
    DELETE sa FROM studentassignment sa
    WHERE sa.assignmentid in (SELECT ca.assignmentid from courseassignment ca
    WHERE ca.courseid=inputid);
    DELETE ca FROM courseassignment ca
    WHERE ca.courseid=inputid;
   
    OPEN cur1;
   
    read_loop: LOOP
    
    FETCH cur1 INTO fetchedid;
    IF done=1 THEN
    LEAVE read_loop;
    END IF;
       
    DELETE tc FROM trainerperclassroom tc
    where tc.classroomid=fetchedid;
    DELETE sc FROM studentperclassroom sc
    WHERE sc.classroomid=fetchedid;
    DELETE c FROM classroom c
    WHERE c.classroomid=fetchedid;
    
    END LOOP;
    DELETE c FROM course c
    WHERE c.courseid=inputid;
    END ;
    
      //
    
    
   DELIMITER //

CREATE PROCEDURE deletecourseassignment(inputid INT)
BEGIN

	DELETE sa FROM studentassignment sa
    where sa.assignmentid=inputid;
    DELETE ca FROM courseassignment ca
    WHERE ca.assignmentid=inputid;
    
    END ;
      //
   
   
    DELIMITER //

CREATE PROCEDURE deletestream(inputid INT)
BEGIN

	DELETE cs FROM courseperstream cs
    where cs.streamid=inputid;
    DELETE s FROM stream s
    WHERE s.streamid=inputid;
    
    END ;
      //

    
-- drop  database  privateschoolproject;

























