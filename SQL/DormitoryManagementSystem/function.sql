CREATE FUNCTION BILL(@StudentID CHAR(8), @SemesterID CHAR(4))
RETURNS FLOAT
AS
BEGIN
	IF NOT EXISTS(SELECT RollNumber FROM STUDENT WHERE RollNumber=@StudentID) 
			OR NOT EXISTS(SELECT ID FROM SEMESTER WHERE ID=@SemesterID)
			OR NOT EXISTS(SELECT * FROM ELECTRICITY_WATER_USED WHERE SemesterID=@SemesterID AND RoomID=(SELECT RoomID FROM STUDENT WHERE RollNumber=@StudentID))
		RETURN 0

	DECLARE @Bill FLOAT;
	DECLARE @Electricity FLOAT;
	DECLARE @Water FLOAT;

	SET @Electricity=
		(SELECT EoSElectricityMeterReading-SoSElectricityMeterReading 
		FROM ELECTRICITY_WATER_USED 
		WHERE @SemesterID=SemesterID AND RoomID=
			(SELECT RoomID FROM STUDENT WHERE RollNumber=@StudentID))

	SET @Water=
		(SELECT EoSWaterMeterReading-SoSWaterMeterReading
		FROM ELECTRICITY_WATER_USED 
		WHERE @SemesterID=SemesterID AND RoomID=
			(SELECT RoomID FROM STUDENT WHERE RollNumber=@StudentID))

	SET @Bill = (SELECT r.Price+(IIF(((@Electricity-150)*3000+(@Water-9)*5000)<=0, 0, ((@Electricity-150)*3000+(@Water-9)*5000))/r.NumberOfStudent)
				FROM STUDENT s
				JOIN ROOM r ON s.RoomID=r.ID
				WHERE s.RollNumber=@StudentID);
	RETURN @Bill
END