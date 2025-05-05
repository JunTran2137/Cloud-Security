CREATE PROCEDURE PAY_BILL
	@StudentID CHAR(8),
	@SemesterID CHAR(4)
AS
BEGIN
	BEGIN TRY
		DECLARE @OldBalance FLOAT
		SET @OldBalance = (SELECT Balance FROM STUDENT WHERE @StudentID = RollNumber)

		IF (dbo.BILL(@StudentID, @SemesterID) > @OldBalance)
			PRINT 'Balance is not enough for payment';
		ELSE
			BEGIN
				UPDATE STUDENT
				SET Balance = @OldBalance - dbo.BILL(@StudentID, @SemesterID)
				WHERE RollNumber=@StudentID
				IF EXISTS(SELECT * FROM PAYING_HISTORY WHERE StudentID=@StudentID AND SemesterID=@SemesterID)
					UPDATE PAYING_HISTORY
					SET Status = 'PAID'
					WHERE StudentID=@StudentID AND SemesterID=@SemesterID
				ELSE
					INSERT INTO PAYING_HISTORY (StudentID, SemesterID, TotalAmount, Status)
					VALUES (@StudentID, @SemesterID, dbo.BILL(@StudentID, @SemesterID), 'PAID')
				PRINT 'PAID SUCCESFULLY'
			END
	END TRY
	BEGIN CATCH
		PRINT 'SOME ERROR OCCURED'
	END CATCH
END

GO

CREATE PROCEDURE ADD_STUDENT
	@RollNumber CHAR(8),
	@FirstName NVARCHAR(50),
	@LastName NVARCHAR(50),
	@DateOfBirth DATE,
	@Gender VARCHAR(6),
	@PhoneNumber CHAR(11),
	@Email VARCHAR(100),
	@Semester INT,
	@RoomID CHAR(5), 
	@DomID CHAR(1),
	@Balance INT,
	@Date DATE = NULL
AS 
BEGIN 
	BEGIN TRY
		IF (SELECT IIF(r.NumberOfStudent >= r.Type, 1, 0) 
			FROM ROOM r
			WHERE r.ID = @RoomID) = 1 
				OR @Gender != (SELECT Gender FROM ROOM r WHERE r.ID = @RoomID)
				OR @Semester >= 6
			BEGIN
				PRINT 'CANNOT ADD TO THIS ROOM'
				RETURN
			END	
        
		SET @Date=CURRENT_TIMESTAMP;

		INSERT INTO STUDENT(RollNumber, FirstName, LastName, DateOfBirth, Gender, PhoneNumber, Email, Semester, RoomID, DomID, Balance)
		VALUES(@RollNumber, @FirstName, @LastName, @DateOfBirth, @Gender, @PhoneNumber, @Email, @Semester, @RoomID, @DomID, @Balance);
		INSERT INTO BOOKING_HISTORY(StudentID, RoomID, DomID, BookingDate, Status)
		VALUES(@RollNumber, @RoomID, @DomID, @Date, 'ACCEPTED');
		INSERT INTO RESIDENT_HISTORY(StudentID, RoomID, DomID, SemesterID)
		VALUES (@RollNumber, @RoomID, @DomID, (SELECT ID FROM SEMESTER WHERE @Date BETWEEN StartTime AND EndTime))
		PRINT 'ADDED STUDENT SUCCESSFULLY'
	END TRY
	BEGIN CATCH
		PRINT 'SOME ERROR OCCURED'
	END CATCH
END

GO

CREATE PROCEDURE MOVE_STUDENT
	@RollNumber CHAR(8),
	@RoomID CHAR(5),
	@DomID CHAR(1),
	@Date DATE = NULL
AS 
BEGIN 
	BEGIN TRY
		IF (SELECT IIF(r.NumberOfStudent >= r.Type, 1, 0) 
			FROM ROOM r
			WHERE r.ID = @RoomID) = 1 
				OR (SELECT Gender FROM STUDENT WHERE RollNumber=@RollNumber) != (SELECT Gender FROM ROOM r WHERE r.ID = @RoomID)
				OR (SELECT Semester FROM STUDENT WHERE RollNumber=@RollNumber) >= 6
			BEGIN
				INSERT INTO BOOKING_HISTORY(StudentID, RoomID, DomID, BookingDate, Status)
				VALUES(@RollNumber, @RoomID, @DomID, @Date, 'REJECTED');
				PRINT 'CANNOT MOVE TO THIS ROOM'
				RETURN
			END

		SET @Date = CURRENT_TIMESTAMP;

		UPDATE STUDENT
		SET RoomID = @RoomID
		WHERE RollNumber = @RollNumber
		INSERT INTO BOOKING_HISTORY(StudentID, RoomID, DomID, BookingDate, Status)
		VALUES(@RollNumber, @RoomID, @DomID, @Date, 'ACCEPTED')
		INSERT INTO RESIDENT_HISTORY(StudentID, RoomID, DomID, SemesterID)
		VALUES (@RollNumber, @RoomID, @DomID, (SELECT ID FROM SEMESTER WHERE @Date BETWEEN StartTime AND EndTime))
		PRINT 'MOVED STUDENT SUCCESSFULLY' 	
	END TRY
	BEGIN CATCH
		PRINT 'SOME ERROR OCCURED'
	END CATCH
END