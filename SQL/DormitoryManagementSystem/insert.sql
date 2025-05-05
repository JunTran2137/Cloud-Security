INSERT INTO DOM (ID, Name) 
VALUES
	('A', 'Dom A'),
	('B', 'Dom B'),
	('C', 'Dom C'),
	('D', 'Dom D'),
	('E', 'Dom E'),
	('F', 'Dom F'),
	('G', 'Dom G'),
	('H', 'Dom H');

INSERT INTO ROOM (ID, DomID, Floor, Position, Side, Gender, Type, Price) 
VALUES
	('A101L', 'A', 1, 1, 'Left', 'Male', 6, 800000),
	('A102R', 'A', 1, 2, 'Right', 'Female', 6, 800000),
	('B201L', 'B', 2, 1, 'Left', 'Male', 6, 800000),
	('B202R', 'B', 2, 2, 'Right', 'Female', 6, 800000),
	('C301L', 'C', 3, 1, 'Left', 'Male', 6, 800000),
	('C302R', 'C', 3, 2, 'Right', 'Female', 6, 800000),
	('D401L', 'D', 4, 1, 'Left', 'Male', 6, 800000),
	('D402R', 'D', 4, 2, 'Right', 'Female', 6, 800000),
	('E501L', 'E', 5, 1, 'Left', 'Male', 4, 1000000),
	('E502R', 'E', 5, 2, 'Right', 'Female', 4, 1000000);

INSERT INTO STUDENT (RollNumber, FirstName, LastName, DateOfBirth, Gender, PhoneNumber, Email, Balance, Semester, RoomID, DomID) 
VALUES
	('HA190001', 'John', 'Doe', '2000-01-01', 'Male', '0123456780', 'john.doe@gmail.com', 100000, 1, 'A101L', 'A'),
    ('HA190002', 'Jane', 'Smith', '2001-02-02', 'Female', '0123456781', 'jane.smith@fpt.edu.vn', 120000, 1, 'A102R', 'A'),
    ('HA190003', 'Mark', 'Johnson', '2002-03-03', 'Male', '0123456782', 'mark.j@gmail.com', 140000, 2, 'B201L', 'B'),
    ('HS190004', 'Emily', 'Davis', '2003-04-04', 'Female', '0123456783', 'emily.d@fpt.edu.vn', 160000, 2, 'B202R', 'B'),
    ('HS190005', 'Michael', 'Brown', '2004-05-05', 'Male', '0123456784', 'michael.b@gmail.com', 180000, 3, 'C301L', 'C'),
    ('HS190006', 'Sarah', 'Wilson', '2005-06-06', 'Female', '0123456785', 'sarah.w@fpt.edu.vn', 110000, 3, 'C302R', 'C'),
    ('HE190007', 'David', 'Moore', '2006-07-07', 'Male', '0123456786', 'david.m@gmail.com', 130000, 4, 'D401L', 'D'),
    ('HE190008', 'Laura', 'Taylor', '2007-08-08', 'Female', '0123456787', 'laura.t@fpt.edu.vn', 150000, 4, 'D402R', 'D'),
    ('HE190009', 'Daniel', 'Anderson', '2008-09-09', 'Male', '0123456788', 'daniel.a@gmail.com', 170000, 5, 'E501L', 'E'),
    ('HE190010', 'Olivia', 'Thomas', '2009-10-10', 'Female', '0123456789', 'olivia.t@fpt.edu.vn', 190000, 5, 'E502R', 'E'),
    ('HA190011', 'Jake', 'Miller', '2000-01-01', 'Male', '0123456800', 'jake.miller@gmail.com', 200000, 1, 'A101L', 'A'),
    ('HA190012', 'Aaron', 'White', '2001-02-02', 'Male', '0123456801', 'aaron.white@gmail.com', 210000, 1, 'A101L', 'A'),
    ('HA190013', 'Sophia', 'Lee', '2002-03-03', 'Female', '0123456802', 'sophia.lee@gmail.com', 220000, 2, 'A102R', 'A'),
    ('HA190014', 'Lily', 'Young', '2003-04-04', 'Female', '0123456803', 'lily.young@gmail.com', 230000, 2, 'A102R', 'A'),
    ('HS190015', 'Chris', 'Scott', '2000-05-05', 'Male', '0123456804', 'chris.scott@gmail.com', 240000, 3, 'B201L', 'B'),
    ('HS190016', 'James', 'Baker', '2001-06-06', 'Male', '0123456805', 'james.baker@gmail.com', 250000, 3, 'B201L', 'B'),
    ('HS190017', 'Mia', 'Wright', '2002-07-07', 'Female', '0123456806', 'mia.wright@gmail.com', 260000, 4, 'B202R', 'B'),
    ('HS190018', 'Emma', 'Mitchell', '2003-08-08', 'Female', '0123456807', 'emma.mitchell@gmail.com', 270000, 4, 'B202R', 'B'),
    ('HE190019', 'Henry', 'Allen', '2000-09-09', 'Male', '0123456808', 'henry.allen@gmail.com', 280000, 5, 'C301L', 'C'),
    ('HE190020', 'Lucas', 'Hill', '2001-10-10', 'Male', '0123456809', 'lucas.hill@gmail.com', 290000, 5, 'C301L', 'C'),
    ('HE190021', 'Lily', 'King', '2002-11-11', 'Female', '0123456810', 'lily.king@gmail.com', 300000, 1, 'C302R', 'C'),
    ('HE190022', 'Ella', 'Parker', '2003-12-12', 'Female', '0123456811', 'ella.parker@gmail.com', 310000, 1, 'C302R', 'C'),
    ('HA190023', 'Logan', 'Perez', '2000-01-13', 'Male', '0123456812', 'logan.perez@gmail.com', 320000, 2, 'D401L', 'D'),
    ('HA190024', 'Ethan', 'Collins', '2001-02-14', 'Male', '0123456813', 'ethan.collins@gmail.com', 330000, 2, 'D401L', 'D'),
    ('HA190025', 'Grace', 'Edwards', '2002-03-15', 'Female', '0123456814', 'grace.edwards@gmail.com', 340000, 3, 'D402R', 'D'),
    ('HA190026', 'Ava', 'Roberts', '2003-04-16', 'Female', '0123456815', 'ava.roberts@gmail.com', 350000, 3, 'D402R', 'D'),
    ('HA190027', 'Matthew', 'Nguyen', '2000-05-17', 'Male', '0123456716', 'matthew.nguyen@gmail.com', 360000, 4, 'A101L', 'A'),
    ('HA190028', 'Ethan', 'Pham', '2001-06-18', 'Male', '0123456717', 'ethan.pham@gmail.com', 370000, 4, 'A101L', 'A'),
    ('HA190029', 'Zara', 'Phan', '2002-07-19', 'Female', '0123456718', 'zara.phan@gmail.com', 380000, 5, 'A102R', 'A'),
    ('HA190030', 'Sophie', 'Tran', '2003-08-20', 'Female', '0123456719', 'sophie.tran@gmail.com', 390000, 5, 'A102R', 'A'),
    ('HS190031', 'Lucas', 'Hernandez', '2000-09-21', 'Male', '0123456720', 'lucas.hernandez@gmail.com', 400000, 1, 'B201L', 'B'),
    ('HS190032', 'Michael', 'Vo', '2001-10-22', 'Male', '0123456721', 'michael.vo@gmail.com', 410000, 1, 'B201L', 'B'),
    ('HS190033', 'Ava', 'Nguyen', '2002-11-23', 'Female', '0123456722', 'ava.nguyen@gmail.com', 420000, 2, 'B202R', 'B'),
    ('HS190034', 'Isabella', 'Le', '2003-12-24', 'Female', '0123456723', 'isabella.le@gmail.com', 430000, 2, 'B202R', 'B'),
    ('HE190035', 'William', 'Tran', '2000-01-25', 'Male', '0123456724', 'william.tran@gmail.com', 440000, 3, 'C301L', 'C'),
    ('HE190036', 'Oliver', 'Hoang', '2001-02-26', 'Male', '0123456725', 'oliver.hoang@gmail.com', 450000, 3, 'C301L', 'C'),
    ('HE190037', 'Lily', 'Phan', '2002-03-27', 'Female', '0123456726', 'lily.phan@gmail.com', 460000, 4, 'C302R', 'C'),
    ('HE190038', 'Grace', 'Bui', '2003-04-28', 'Female', '0123456727', 'grace.bui@gmail.com', 470000, 4, 'C302R', 'C'),
    ('HS190039', 'Noah', 'Le', '2000-05-29', 'Male', '0123456728', 'noah.le@gmail.com', 480000, 5, 'D401L', 'D'),
    ('HS190040', 'James', 'Nguyen', '2001-06-30', 'Male', '0123456729', 'james.nguyen@gmail.com', 490000, 5, 'D401L', 'D'),
    ('HS190041', 'Emily', 'Ho', '2002-07-31', 'Female', '0123456730', 'emily.ho@gmail.com', 500000, 1, 'D402R', 'D'),
    ('HS190042', 'Ava', 'Nguyen', '2003-08-01', 'Female', '0123456731', 'ava.nguyen@gmail.com', 510000, 1, 'D402R', 'D'),
    ('HE190043', 'Benjamin', 'Clark', '2004-01-02', 'Male', '0123456732', 'benjamin.clark@gmail.com', 520000, 2, 'E501L', 'E'),
    ('HE190044', 'Oliver', 'Walker', '2004-02-03', 'Male', '0123456733', 'oliver.walker@gmail.com', 530000, 2, 'E501L', 'E'),
    ('HE190045', 'Samantha', 'Adams', '2004-03-04', 'Female', '0123456734', 'samantha.adams@gmail.com', 540000, 3, 'E502R', 'E'),
    ('HE190046', 'Chloe', 'Taylor', '2004-04-05', 'Female', '0123456735', 'chloe.taylor@gmail.com', 550000, 3, 'E502R', 'E');
	
INSERT INTO SEMESTER (ID, Name, StartTime, EndTime) 
VALUES
    ('FA21', 'Fall 2021', '2021-09-01', '2021-12-31'),
    ('SP22', 'Spring 2022', '2022-01-01', '2022-04-30'), 
    ('SU22', 'Summer 2022', '2022-05-01', '2022-08-31'),
    ('FA22', 'Fall 2022', '2022-09-01', '2022-12-31'),
    ('SP23', 'Spring 2023', '2023-01-01', '2023-04-30'), 
    ('SU23', 'Summer 2023', '2023-05-01', '2023-08-31'),
    ('FA23', 'Fall 2023', '2023-09-01', '2023-12-31'),
    ('SP24', 'Spring 2024', '2024-01-01', '2024-04-30'), 
    ('SU24', 'Summer 2024', '2024-05-01', '2024-08-31'),
    ('FA24', 'Fall 2024', '2024-09-01', '2024-12-31');

INSERT INTO ELECTRICITY_WATER_USED (RoomID, DomID, SemesterID, SoSElectricityMeterReading, EoSElectricityMeterReading, SoSWaterMeterReading, EoSWaterMeterReading) 
VALUES
	('A101L', 'A', 'SU23', 1000, 1190, 500, 510),
    ('A101L', 'A', 'FA23', 1190, 1360, 510, 522),
    ('A101L', 'A', 'SP24', 1360, 1510, 522, 536),
    ('A101L', 'A', 'SU24', 1510, 1640, 536, 552),
    ('A101L', 'A', 'FA24', 1640, 1750, 552, 570),
    ('A102R', 'A', 'SU23', 2000, 2180, 600, 611),
    ('A102R', 'A', 'FA23', 2180, 2340, 611, 624),
    ('A102R', 'A', 'SP24', 2340, 2480, 624, 639),
    ('A102R', 'A', 'SU24', 2480, 2600, 639, 656),
    ('A102R', 'A', 'FA24', 2600, 2700, 656, 675);

INSERT INTO RESIDENT_HISTORY (StudentID, SemesterID, RoomID, DomID) 
VALUES
	('HA190001', 'SU23', 'A101L', 'A'),
	('HA190001', 'FA23', 'A102R', 'A'),
	('HA190001', 'SP24', 'B201L', 'B'),
	('HA190001', 'SU24', 'B202R', 'B'),
	('HA190001', 'FA24', 'C301L', 'C'),
	('HS190004', 'SU23', 'C302R', 'C'),
	('HS190004', 'FA23', 'D401L', 'D'),
	('HS190004', 'SP24', 'D402R', 'D'),
	('HS190004', 'SU24', 'E501L', 'E'),
	('HS190004', 'FA24', 'E502R', 'E');

INSERT INTO PAYING_HISTORY (StudentID, SemesterID, TotalAmount, Status) 
VALUES
	('HA190001', 'SU23', dbo.BILL('HA190001', 'SU23'), 'UNPAID'),
	('HA190001', 'FA23', dbo.BILL('HA190001', 'FA23'), 'PAID'),
	('HA190001', 'SP24', dbo.BILL('HA190001', 'SP24'), 'PAID'),
	('HA190001', 'SU24', dbo.BILL('HA190001', 'SU24'), 'PAID'),
	('HA190001', 'FA24', dbo.BILL('HA190001', 'FA24'), 'PAID'),
	('HS190004', 'SU23', dbo.BILL('HA190001', 'SU23'), 'PAID'),
	('HS190004', 'FA23', dbo.BILL('HA190001', 'FA23'), 'PAID'),
	('HS190004', 'SP24', dbo.BILL('HA190001', 'SP24'), 'PAID'),
	('HS190004', 'SU24', dbo.BILL('HA190001', 'SU24'), 'PAID'),
	('HS190004', 'FA24', dbo.BILL('HA190001', 'FA24'), 'PAID');

INSERT INTO BOOKING_HISTORY (StudentID, RoomID, DomID, Status, BookingDate)
VALUES
	('HA190001', 'A101L', 'A', 'ACCEPTED', '2023-05-01'),
	('HA190001', 'A102R', 'A', 'ACCEPTED', '2023-09-01'),
	('HA190001', 'B201L', 'B', 'ACCEPTED', '2024-01-01'),
	('HA190001', 'E501L', 'E', 'REJECTED', '2024-05-01'),
	('HA190001', 'C301L', 'C', 'ACCEPTED', '2024-09-01'),
	('HS190004', 'C302R', 'C', 'ACCEPTED', '2023-05-01'),
	('HS190004', 'D401L', 'D', 'ACCEPTED', '2023-09-01'),
	('HS190004', 'D402R', 'D', 'ACCEPTED', '2024-01-01'),
	('HS190004', 'B202R', 'B', 'REJECTED', '2024-05-01'),
	('HS190004', 'E502R', 'E', 'ACCEPTED', '2024-09-01');

INSERT INTO ROLE (Name, Salary) 
VALUES
	('Manager', 10000),
	('Security', 8000),
	('Janitor', 6000),
	('Engineer', 6000),
	('Laundry', 5000)

INSERT INTO STAFF (FirstName, LastName, DateOfBirth, Gender, PhoneNumber, Email, DomID, RoleID) 
VALUES
	('Alice', 'Green', '1985-01-15', 'Male', '0987654321', 'alice.green@gmail.com', 'A', 1),
	('Bob', 'Smith', '1990-02-20', 'Female', '0876543210', 'bob.smith@gmail.com', 'B', 2),
	('Charlie', 'Johnson', '1988-03-25', 'Male', '0765432109', 'charlie.j@gmail.com', 'C', 3),
	('Diana', 'Brown', '1995-04-30', 'Female', '0654321098', 'diana.brown@gmail.com', 'D', 4),
	('Eva', 'Williams', '1982-05-10', 'Male', '0543210987', 'eva.w@gmail.com', 'E', 5),
	('Frank', 'Jones', '1992-06-15', 'Female', '0432109876', 'frank.jones@gmail.com', 'A', 1),
	('Grace', 'Davis', '1989-07-20', 'Male', '0321098765', 'grace.davis@gmail.com', 'B', 2),
	('Henry', 'Miller', '1987-08-25', 'Female', '0210987654', 'henry.miller@gmail.com', 'C', 3),
	('Isabella', 'Wilson', '1993-09-30', 'Male', '0109876543', 'isabella.w@gmail.com', 'D', 4),
	('Jack', 'Moore', '1984-10-05', 'Female', '0998765432', 'jack.moore@gmail.com', 'E', 5);
