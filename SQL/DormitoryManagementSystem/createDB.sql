--USE DOM
CREATE TABLE DOM(
	ID CHAR(1) PRIMARY KEY CHECK(ID LIKE '[A-H]'),
	Name CHAR(5) NOT NULL CHECK(NAME LIKE ('Dom [A-H]'))
)

CREATE TABLE ROOM(
	ID CHAR(5) CHECK(ID LIKE '[A-H][1-5]1[0-4][RL]' OR ID LIKE '[A-H][1-5]0[1-9][RL]'),
	DomID CHAR(1) NOT NULL FOREIGN KEY REFERENCES DOM(ID),
	PRIMARY KEY(ID, DomID), 
	Floor INT NOT NULL CHECK(Floor BETWEEN 1 AND 5),
	Position INT NOT NULL CHECK(Position BETWEEN 1 AND 14),
	Side VARCHAR(5) NOT NULL CHECK(Side IN ('Left', 'Right')),
	Gender VARCHAR(6) NOT NULL CHECK(Gender IN ('Male', 'Female')),
	Type INT NOT NULL CHECK(Type in (4, 6)),
	Price INT NOT NULL CHECK(Price > 0),
	NumberOfStudent INT NOT NULL DEFAULT 0
)

CREATE TABLE STUDENT(
	RollNumber CHAR(8) PRIMARY KEY CHECK(RollNumber LIKE 'H[ESA][0-9][0-9][0-9][0-9][0-9][0-9]'),
	FirstName NVARCHAR(50) NOT NULL CHECK(FirstName LIKE '[A-Z]%'),
	LastName NVARCHAR(50) NOT NULL CHECK(LastName LIKE '[A-Z]%'),
	DateOfBirth DATE NOT NULL,
	Gender VARCHAR(6) NOT NULL CHECK(Gender IN ('Male', 'Female')),
	PhoneNumber CHAR(10) NOT NULL CHECK(PhoneNumber LIKE '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Email VARCHAR(100) NOT NULL CHECK(Email LIKE '%@fpt.edu.vn' OR Email LIKE '%@gmail.com'),
	Semester INT NOT NULL CHECK(Semester BETWEEN 1 AND 9),
	RoomID CHAR(5) NOT NULL,
	DomID CHAR(1) NOT NULL,
	FOREIGN KEY (RoomID, DomID) REFERENCES Room(ID, DomID),
	Balance FLOAT NOT NULL DEFAULT 0 CHECK(Balance>=0)
)

CREATE TABLE SEMESTER(
	ID CHAR(4) PRIMARY KEY CHECK (ID LIKE 'FA[0-9][0-9]' OR ID LIKE 'SP[0-9][0-9]' OR ID LIKE 'SU[0-9][0-9]'),
	Name VARCHAR(11) NOT NULL CHECK(Name LIKE 'Fall [0-9][0-9][0-9][0-9]' OR Name LIKE 'Spring [0-9][0-9][0-9][0-9]' OR Name LIKE 'Summer [0-9][0-9][0-9][0-9]'),
	StartTime DATE NOT NULL,
	EndTime DATE NOT NULL,
	CHECK(StartTime < EndTime)
)

CREATE TABLE ELECTRICITY_WATER_USED(
	RoomID CHAR(5) NOT NULL,
	DomID CHAR(1) NOT NULL,
	FOREIGN KEY (RoomID, DomID) REFERENCES Room(ID, DomID),
	SemesterID CHAR(4) FOREIGN KEY REFERENCES Semester(ID),
	PRIMARY KEY(RoomID, DomID, SemesterID),
	SoSElectricityMeterReading FLOAT NOT NULL,
	EoSElectricityMeterReading FLOAT NOT NULL,
	CHECK(SoSElectricityMeterReading >=0 AND SoSElectricityMeterReading<=EoSElectricityMeterReading),
	SoSWaterMeterReading FLOAT NOT NULL,
	EoSWaterMeterReading FLOAT NOT NULL,
	CHECK(SoSWaterMeterReading >=0 AND SoSWaterMeterReading<=EoSWaterMeterReading)
)

CREATE TABLE RESIDENT_HISTORY(
	StudentID CHAR(8) FOREIGN KEY REFERENCES Student(RollNumber),
	SemesterID CHAR(4) FOREIGN KEY REFERENCES Semester(ID),
	PRIMARY KEY(StudentID, SemesterID),
	RoomID CHAR(5) NOT NULL,
	DomID CHAR(1) NOT NULL,
	FOREIGN KEY (RoomID, DomID) REFERENCES Room(ID, DomID),
)

CREATE TABLE PAYING_HISTORY(
	StudentID CHAR(8) FOREIGN KEY REFERENCES Student(RollNumber),
	SemesterID CHAR(4) FOREIGN KEY REFERENCES Semester(ID),
	PRIMARY KEY(StudentID, SemesterID),
	TotalAmount INT NOT NULL DEFAULT 0,
	Status VARCHAR(8) NOT NULL CHECK(Status in ('PAID', 'UNPAID'))
)

CREATE TABLE BOOKING_HISTORY(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	StudentID CHAR(8) FOREIGN KEY REFERENCES Student(RollNumber),
	RoomID CHAR(5) NOT NULL,
	DomID CHAR(1) NOT NULL,
	FOREIGN KEY (RoomID, DomID) REFERENCES Room(ID, DomID),
	BookingDate DATE NOT NULL,
	Status VARCHAR(8) NOT NULL CHECK(Status in ('ACCEPTED', 'REJECTED'))
)

CREATE TABLE ROLE(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	Name VARCHAR(30) NOT NULL CHECK(Name IN ('Security', 'Laundry', 'Janitor', 'Manager', 'Engineer')),
	Salary INT NOT NULL CHECK(Salary > 0)
)

CREATE TABLE STAFF(
	ID INT IDENTITY(1,1),
	FirstName NVARCHAR(50) NOT NULL CHECK(FirstName LIKE '[A-Z]%'),
	LastName NVARCHAR(50) NOT NULL CHECK(LastName LIKE '[A-Z]%'),
	DateOfBirth DATE NOT NULL,
	Gender VARCHAR(6) NOT NULL CHECK(Gender IN ('Male', 'Female')),
	PhoneNumber CHAR(10) NOT NULL CHECK(PhoneNumber LIKE '0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Email VARCHAR(100) NOT NULL CHECK(Email LIKE '%@gmail.com'),
	DomID CHAR(1) NOT NULL FOREIGN KEY REFERENCES DOM(ID),
	RoleID INT
)