--Liet tat ca cac phong con cho va sinh vien trong phong do
SELECT 
	r.ID Room, 
	s.*
FROM ROOM r
JOIN STUDENT s on r.ID=s.RoomID
WHERE r.NumberOfStudent<r.Type
ORDER BY r.ID

--Liet ke nhan vien cua tat ca cac dom
SELECT 
	d.Name Dom,
	s.ID,
	(s.FirstName+' '+s.LastName) [Staff Name],
	r.Name Role,
	r.Salary
FROM STAFF s
JOIN DOM d ON d.ID=s.DomID
JOIN ROLE r ON r.ID=s.RoleID

--Liet ke nhung phong da tung o cua tat ca sinh vien
SELECT 
	st.RollNumber,
	(st.FirstName+' '+st.LastName) [Student Name],
	sm.Name Semester,
	rh.RoomID Room
FROM STUDENT st
LEFT JOIN RESIDENT_HISTORY rh
ON st.RollNumber=rh.StudentID
LEFT JOIN SEMESTER sm
ON rh.SemesterID=sm.ID

--Liet ke lich su thanh toan cua tat ca sinh vien
SELECT 
	st.RollNumber,
	(st.FirstName+' '+st.LastName) [Student Name],
	sm.Name Semester,
	rh.TotalAmount,
	rh.Status
FROM STUDENT st
LEFT JOIN PAYING_HISTORY rh
ON st.RollNumber=rh.StudentID
LEFT JOIN SEMESTER sm
ON rh.SemesterID=sm.ID

--Liet ke phong su dung it nuoc nhat
SELECT 
	e.RoomID,
	s.Name Semester,
	(e.EoSElectricityMeterReading-e.SoSElectricityMeterReading) ElectricityUsage,
	(e.EoSWaterMeterReading-e.SoSWaterMeterReading) WaterUsage
FROM ELECTRICITY_WATER_USED e
JOIN SEMESTER s ON s.ID=e.SemesterID
WHERE (e.EoSWaterMeterReading-e.SoSWaterMeterReading)=(SELECT MIN(EoSWaterMeterReading-SoSWaterMeterReading) FROM ELECTRICITY_WATER_USED)

--Liet ke phong su dung nhieu dien nhat
SELECT 
	e.RoomID,
	s.Name Semester,
	(e.EoSElectricityMeterReading-e.SoSElectricityMeterReading) ElectricityUsage,
	(e.EoSWaterMeterReading-e.SoSWaterMeterReading) WaterUsage
FROM ELECTRICITY_WATER_USED e
JOIN SEMESTER s ON s.ID=e.SemesterID
WHERE (e.EoSElectricityMeterReading-e.SoSElectricityMeterReading)=(SELECT MAX(EoSElectricityMeterReading-SoSElectricityMeterReading) FROM ELECTRICITY_WATER_USED)

--Liet ke nhung phong da o cua sinh vien co ma sinh vien HA190001
SELECT
	st.RollNumber,
	(st.FirstName+' '+st.LastName) [Student Name],
	sm.Name Semester,
	r.RoomID Room
FROM (SELECT * FROM RESIDENT_HISTORY WHERE StudentID='HA190001') r
JOIN SEMESTER sm ON sm.ID=r.SemesterID
JOIN STUDENT st ON st.RollNumber=r.StudentID

--Liet ke nhung phong phai tra tien dien nuoc
SELECT 
	e.RoomID,
	s.Name Semester,
	(e.EoSElectricityMeterReading-e.SoSElectricityMeterReading) ElectricityUsage,
	(e.EoSWaterMeterReading-e.SoSWaterMeterReading) WaterUsage
FROM (SELECT * FROM ELECTRICITY_WATER_USED WHERE 
	((EoSElectricityMeterReading-SoSElectricityMeterReading)*3000
	+ (EoSWaterMeterReading-SoSWaterMeterReading)*5000) > (150*3000+9*5000))e
JOIN SEMESTER s ON s.ID=e.SemesterID

--Liet ke tong dien va nuoc da su dung cua tung phong
SELECT 
	e.RoomID Room,
	SUM(e.EoSElectricityMeterReading-e.SoSElectricityMeterReading) ElectricityUsage,
	SUM(e.EoSWaterMeterReading-e.SoSWaterMeterReading) WaterUsage
FROM ELECTRICITY_WATER_USED e
JOIN SEMESTER s
ON e.SemesterID=s.ID
GROUP BY e.RoomID

--Liet ke tong so luot dat phong cua tat ca sinh vien
SELECT
	s.RollNumber,
	(s.FirstName+' '+s.LastName) [Student Name],
	COUNT(b.ID) [Total bookings]
FROM BOOKING_HISTORY b
JOIN STUDENT s ON b.StudentID=s.RollNumber
GROUP BY s.RollNumber, (s.FirstName+' '+s.LastName)