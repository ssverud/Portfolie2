DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Grade;
DROP TABLE IF EXISTS GradeAVG;

CREATE TABLE IF NOT EXISTS Students (
                                        ID INTEGER NOT NULL PRIMARY KEY,
                                        FirstName VARCHAR NOT NULL,
                                        LastName VARCHAR NOT NULL,
                                        Address VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Course (
                                      Number INTEGER NOT NULL PRIMARY KEY,
                                      Season VARCHAR NOT NULL,
                                      Name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Grade (
                                     StudentID INTEGER NOT NULL,
                                     Grade INTEGER,
                                     CourseID INTEGER NOT NULL,
                                     foreign key (StudentID) references Students (FirstName) ON DELETE RESTRICT ON UPDATE CASCADE,
                                     foreign key (CourseID) references Course (Number) ON DELETE RESTRICT ON UPDATE CASCADE

);

INSERT INTO Students (ID, FirstName, LastName, Address)  VALUES
(1,'Aisha','Lincoln','Nykøbing F'),
(2,'Anya','Nielsen','Nykøbing F'),
(3,'Benjamin','Jensen','Camas'),
(4,'Berta','Bertelsen','Billund'),
(5,'Albert','Antonsen','Sorø'),
(6,'Eske','Eriksen','Eskildstrup'),
(7,'Olaf','Olsen','Odense'),
(8,'Salma','Simonsen','Stockholm'),
(9,'Theis','Thomasen','Tølløse'),
(10,'Janet','Jensen','Jyllinge');


INSERT INTO Course (Number, Name, Season) VALUES
(1,'ES12019','autum'),
(2,'SD2019','autum'),
(3,'SD2020','spring');

INSERT INTO Grade (StudentID, CourseID, Grade) VALUES
(1,2,12),(1,1,10),
(2,3,NULL),(2,1,12),
(3,2,7),(3,1,10),
(4,3,NULL),(4,1,2),
(5,2,10),(5,1,7),
(6,3,NULL),(6,1,10),
(7,2,4),(7,1,12),
(8,3,NULL),(8,1,12),
(9,2,12),(9,1,12),
(10,3,NULL),(10,1,7);