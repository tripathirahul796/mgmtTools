CREATE PROC pAddAudit
@relatedId VARCHAR(50),
@eventName VARCHAR(50),
@descriptions VARCHAR(500),
@actionUser VARCHAR(100)
AS
BEGIN
	
	BEGIN
		INSERT INTO Audit VALUES(@relatedId, @eventName, @descriptions,@actionUser,GETDATE());
	END
END




