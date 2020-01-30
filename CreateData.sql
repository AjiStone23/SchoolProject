USE privateschoolproject;

INSERT INTO TimeType VALUES 
(null, 'FULL_TIME'),
(null,'PART_TIME');

INSERT INTO course VALUES
(null,'Introduction to Programming in Java','2020-2-15','2020-5-13',2),
(null,'Introduction to Programming in Java','2020-3-15','2020-5-13',1),
(null,'Assembly','2020-3-15','2020-4-25',1),
(null,'Algorithms','2020-4-1','2020-5-19',1),
(null,'Dynamic programming','2020-2-18','2020-4-13',2),
(null,'Abstract Algebra','2020-4-15','2020-7-28',1),
(null,'Number Theory','2020-3-7','2020-7-15',2),
(null,'Advanced Math Topics','2020-2-7','2020-5-29',2),
(null,'Object oriented programming','2020-5-16','2020-8-29',1),
(null,'C++','2020-3-16','2020-8-29',1),
(null, 'Introduction to Logic','2020-5-18','2020-7-2',2),
(null, 'Introduction to Deep Learning','2020-3-15','2020-5-19',1),
(null, 'Data Structures and Algorithms','2020-4-19','2020-6-25',1);



INSERT INTO stream VALUES
(null,'Learn Programming with Java'),
(null, 'Learn Programming with C++'),
(null, 'Algorithms and Complexity');


INSERT INTO CourseAssignment VALUES
(null,'Algebra Problems 1','Do the assignment','2020-5-13',30,100,6),
(null,'Algebra Problems 2','Do the assignment','2020-7-13',30,100,6),
(null,'Rieamann Surfaces','Do the assignment','2020-3-9',30,100,8),
(null,'Fourier Analysis','Do the assignment','2020-5-18',30,100,8),
(null,'NP problems','Do the assignment','2020-5-7',30,100,4),
(null,'Assembly Problems','Do the assignment','2020-4-13',30,100,3),
(null,'C++ assignment I','Do the assignment','2020-3-27',30,100,10),
(null,'C++ assignment II','Do the assignment','2020-8-13',30,100,10),
(null,'Dynamic problems','Do the assignment','2020-3-3',30,100,5),
(null,'Inheritance','Do the assignment','2020-2-28',30,100,1),
(null,'Lamda expr','Do the assignment','2020-3-13',30,100,1),
(null,'Streams','Do the assignment','2020-5-11',30,100,1),
(null,'Prime Numbers','Do the assignment','2020-4-7',30,100,7),
(null,'Cryptography','Do the assignment','2020-6-26',30,100,7),
(null,'Design Project','Do the assignment','2020-7-27',30,100,9),
(null,'Inheritance','Do the assignment','2020-4-13',30,100,2),
(null,'Structure prj','Do the assignment','2020-5-15',30,100,13),
(null,'Grapg prj','Do the assignment','2020-6-18',30,100,13),
(null,'Graph exercise','Do the assignment','2020-3-29',30,100,12),
(null,'Problems with Python','Do the assignment','2020-4-28',30,100,12),
(null,'Logic pack I','Do the assignment','2020-6-2',30,100,11),
(null,'Logic pack II','Do the assignment','2020-6-26',30,100,11),
(null,'Logic pack III','Do the assignment','2020-7-1',30,100,11);


INSERT INTO subject VALUES
(null,'COMPUTER_SCIENCE'),
(null,'MATH');

INSERT INTO courseperstream VALUES
(1,1),(9,1),(6,1),(4,1),(10,2),(4,2),(6,2),
(4,3),(8,3),(6,3),(5,3);


INSERT INTO student VALUES
(null,'JOHN', 'JONES','2000-10-12', 500.00),
(null,'BILL', 'HICKS','1988-1-13', 750.00),
(null,'GENA', 'ROWLANDS','1978-7-15', 640.50),
(null,'FRED', 'DRAPER','1995-8-28', 855.50),
(null,'MATTHEW', 'CASSEL','1996-5-26', 750.00),
(null,'MARIO', 'GALO','1990-8-14', 350.00),
(null,'KATHERINE', 'CASSAVETES','1988-10-9', 480.50),
(null,'CHRISTINA', 'GRISANTI','1987-3-16', 490.00),
(null,'GEORGE', 'DUNN','1993-12-13', 500.00),
(null,'BEN', 'GAZZARA','1996-9-23', 500.00),
(null,'ROBERT', 'PHILLIPS','1990-9-28', 890.50),
(null,'MIA', 'FARROW','1999-11-7', 730.00),
(null,'JOAN', 'BLONDEL','2000-10-13', 700.00),
(null,'LAURA', 'JOHNSON','2002-12-1', 500.00),
(null,'JOHN', 'FINNEGAN','2001-6-25', 700.00),
(null,'ZOHRA', 'LAMPERT','1999-5-22', 630.00),
(null,'PAUL', 'STEWART','1998-1-12', 370.50),
(null,'ELEANOR', 'ZEE','1993-4-6', 220.00),
(null,'CLAIRE', 'MALIS','1990-10-22', 640.50),
(null,'ANNE', 'WIAZEMSKI','1987-10-13', 700.00),
(null,'JEAN', 'GUILBERT','1999-12-1', 500.00),
(null,'WALTER', 'GREEN','1998-6-25', 700.00),
(null,'GUY', 'BREJAC','1990-5-22', 630.00),
(null,'ROLAND', 'MONOD','1999-1-12', 370.50),
(null,'CHRISTIAN', 'PATEY','2000-4-6', 220.00),
(null,'CAROLINE', 'LANG','2001-10-22', 640.50);




INSERT INTO trainer VALUES
(null,'WINONA','RIDER','1990-5-4',1),
(null,'JOHN','LURIE','1999-12-3',2),
(null,'RICHARD','EDSON','1988-1-17',1),
(null,'ESZTER','BALINT','1984-5-4',2),
(null,'TOM','DICILO','1983-5-4',1);


INSERT INTO  classroom VALUES
(null,'Java Class FullTime',2),
(null, 'Java Class PartTime',1),
(null, 'AdancedMath Class I',8),
(null,'Algorithms Class',4),
(null,'C++ Class',10),
(null,'Algebra Class',6),
(null,'AdvancedMath Class II',8),
(null,'Assembly Class',3),
(null,'Number Theory Class',7),
(null,'Data Class I',13),
(null,'Logic Class',11),
(null,'DeepLearning Class',12),
(null,'Dynamic Class',5);



INSERT INTO  TrainerPerClassRoom VALUES
(1,2),(1,3),(2,1),(3,3),(4,2),(4,4),
(5,5),(5,6),(3,7),
(1,8),(3,8),(2,9),(3,10),(4,11),(5,11),
(5,12),(5,13),(3,13);


INSERT INTO   StudentPerClassRoom VALUES
(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,2),
(9,2),(10,2),(11,2),(12,2),(13,3),(14,3),(15,3),(16,3),
(17,3),(18,3),(20,4),(1,4),(2,4),(3,4),(4,4),(5,4),
(6,4),(7,4),(11,4),(15,5),(18,5),(19,5),(13,5),(14,5),
(1,5),(2,5),(4,5),(5,6),(21,6),(7,6),(8,7),(9,7),
(10,7),(1,8),(2,8),(4,8),(5,8),(6,9),(21,9),(8,9),(9,9),
(10,9),
(26,5),(25,10),(24,10),(5,10),(6,10),(7,10),(8,10),(9,11),
(10,11),(1,11),(2,11),(23,11),(5,12),(6,12),(22,12),(8,13),(9,13),
(10,13);


